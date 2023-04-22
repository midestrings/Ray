package com.ray.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.ray.user.entity.AuthenticationEntity;
import com.ray.user.entity.UserEntity;
import com.ray.user.entity.UserEntityRole;
import com.ray.user.grpc.Authentication;
import com.ray.user.grpc.User;
import com.ray.user.grpc.UserFilter;
import com.ray.user.util.Role;
import com.ray.user.util.Status;
import com.ray.user.util.Type;
import com.ray.user.util.Utility;
import com.ray.user.util.email.EmailUtil;
import com.ray.user.util.hibernate.EntityService;
import com.ray.user.util.hibernate.HibernateUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

import static com.ray.user.UserInfoServer.getProperties;

public class UserService {
    private static final Logger LOG = LogManager.getLogger(UserService.class);
    private static final EntityService<UserEntity> userService = new EntityService<>(UserEntity.class);
    private static final EntityService<AuthenticationEntity> authService = new EntityService<>(AuthenticationEntity.class);

    public Optional<User> createUser(User user) {
        try {
            validateUser(user);
            if (getUserByEmailWithoutSession(user.getEmail()).isPresent())
                throw new RuntimeException("User with email already exists");
            var userEntity = UserEntity.getInstance(user);

            var roles = new LinkedList<UserEntityRole>();
            roles.add(new UserEntityRole(Role.User_Client));
            if (Type.Vendor.equals(user.getType())) roles.add(new UserEntityRole(Role.User_Vendor));
            userEntity.setRoles(roles);
            userEntity.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
            userEntity.setOtp(generateOTP());
            userEntity.setStatus(Status.Unverified);
            userService.save(userEntity);
            EmailUtil.sendEmail("Verify your email", user.getEmail(),
                    String.format("Verify your email on the Ray app.\nHere is your one time passcode <strong>%s</strong>", userEntity.getOtp()));
            return Optional.of(UserEntity.getUser(userEntity, false));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
            return Optional.of(User.newBuilder().setError(e.getMessage()).build());
        }
    }

    public Optional<Authentication> login(User user) {
        if (Utility.isInvalidEmail(user.getEmail())) {
            return Optional.of(Authentication.newBuilder().setError("Enter valid email").build());
        }
        if (Utility.isInvalidPassword(user.getPassword())) {
            return Optional.of(Authentication.newBuilder().setError("Enter valid password").build());
        }
        try {
            var savedUser = getUserByEmailWithoutSession(user.getEmail()).orElse(null);
            if (savedUser == null || !BCrypt.verifyer().verify(user.getPassword().toCharArray(), savedUser.getPassword()).verified) {
                return Optional.of(Authentication.newBuilder().setError("Invalid credentials").build());
            }

            if (Status.Unverified.equals(savedUser.getStatus())) {
                savedUser.setOtp(generateOTP());
                userService.updateWithoutSession(savedUser);
                EmailUtil.sendEmail("Verify your email", user.getEmail(),
                        "Verify your email on the Ray app.\nHere is your one time passcode\n" + savedUser.getOtp());
                return Optional.of(Authentication.newBuilder().setError("OTP").build());
            }

            return getAuthentication(savedUser);
        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public Optional<Authentication> resendOTP(User user) {
        if (Utility.isInvalidEmail(user.getEmail())) {
            return Optional.of(Authentication.newBuilder().setError("Enter valid email").build());
        }
        if (Utility.isInvalidPassword(user.getPassword())) {
            return Optional.of(Authentication.newBuilder().setError("Enter valid password").build());
        }
        try {
            var savedUser = getUserByEmailWithoutSession(user.getEmail()).orElse(null);
            if (savedUser == null) {
                return Optional.of(Authentication.newBuilder().setError("Invalid credentials").build());
            }

            savedUser.setOtp(generateOTP());
            userService.updateWithoutSession(savedUser);
            EmailUtil.sendEmail("Verify your email", user.getEmail(),
                    "Verify your email on the Ray app.\nHere is your one time passcode\n" + savedUser.getOtp());
            return Optional.of(Authentication.newBuilder().setError("OTP").build());

        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public Optional<Authentication> refreshToken(Authentication auth) {
        if (Utility.isEmpty(auth.getRefreshToken())) {
            return Optional.of(Authentication.newBuilder().setError("Invalid refresh token").build());
        }
        try {
            var session = HibernateUtil.getSession();
            var query = session.createQuery("from Authentication auth join fetch auth.user where auth.refreshToken = :token", AuthenticationEntity.class)
                    .setParameter("token", auth.getRefreshToken());
            var savedAuth = getSingleAuthenticationEntity(query);
            session.close();

            if (savedAuth == null)
                return Optional.of(Authentication.newBuilder().setError("Invalid refresh token").build());
            if (LocalDate.now().isAfter(savedAuth.getRefreshTokenExpiry())) {
                return Optional.of(Authentication.newBuilder().setError("Refresh token expired").build());
            }

            savedAuth.setToken(generateToken(savedAuth.getUser()));
            savedAuth.setRefreshTokenExpiry(LocalDate.now().plusYears(1L));
            savedAuth.setUpdatedAt(LocalDateTime.now());
            authService.updateWithoutSession(savedAuth);
            return Optional.of(AuthenticationEntity.getAuthentication(savedAuth));

        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public Optional<User> updateUser(User user) {
        try (var session = HibernateUtil.getSession()) {
            if (Utility.isEmpty(user.getName())) throw new RuntimeException("Invalid name");
            if (Utility.isEmpty(user.getType()) && !Type.types.contains(user.getType()))
                throw new RuntimeException("Invalid type");
            var savedUser = getUserByEmail(user.getEmail(), session).orElseThrow();
            UserEntity.updateInstance(user, savedUser);
            userService.update(savedUser, session);
            return Optional.of(UserEntity.getUser(savedUser, true));
        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.info(e.getMessage(), e);
            return Optional.of(User.newBuilder().setError("Error updating user").build());
        }
    }

    public Optional<User> getUser(User user) {
        if (Utility.isInvalidEmail(user.getEmail())) return Optional.empty();
        try (var session = HibernateUtil.getSession()) {
            var savedUser = getUserByEmail(user.getEmail(), session).orElseThrow(() -> new RuntimeException("User not found"));
            return Optional.of(UserEntity.getUser(savedUser, user.getLoadImage()));
        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.error(e.getMessage(), e);
            return Optional.of(User.newBuilder().setError(e.getMessage()).build());
        }
    }

    public Optional<Authentication> activateUser(User user) {
        if (Utility.isInvalidEmail(user.getEmail())) {
            return Optional.of(Authentication.newBuilder().setError("Invalid Email").build());
        }
        try {
            var savedUser = getUserByEmailWithoutSession(user.getEmail()).orElseThrow();
            if (!savedUser.getOtp().equals(user.getOtp())) {
                return Optional.of(Authentication.newBuilder().setError("Invalid OTP").build());
            }
            savedUser.setStatus(Status.Active);
            userService.updateWithoutSession(savedUser);
            return getAuthentication(savedUser);

        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.error(e.getMessage(), e);
        }
        return Optional.of(Authentication.newBuilder().setError("Verification error").build());
    }

    public Stream<User> getAllUsers(UserFilter filter) {
        return Stream.of();
    }

    private Optional<Authentication> getAuthentication(UserEntity savedUser) {
        var auth = new AuthenticationEntity();
        auth.setUser(savedUser);
        auth.setToken(generateToken(savedUser));
        auth.setRefreshToken(UUID.randomUUID().toString());
        auth.setRefreshTokenExpiry(LocalDate.now().plusYears(1L));
        auth.setCreatedAt(LocalDateTime.now());
        authService.save(auth);
        return Optional.of(AuthenticationEntity.getAuthentication(auth));
    }

    private Optional<UserEntity> getUserByEmail(String email, Session session) {
        var query = session.createQuery("from User where email = :email", UserEntity.class);
        query.setParameter("email", email);
        var savedUser = getSingleUser(query);
        return savedUser != null ? Optional.of(savedUser) : Optional.empty();
    }

    private Optional<UserEntity> getUserByEmailWithoutSession(String email) {
        var session = HibernateUtil.getSession();
        var savedUser = getUserByEmail(email, session).orElse(null);
        session.close();
        return savedUser != null ? Optional.of(savedUser) : Optional.empty();
    }

    private String generateToken(UserEntity user) {
        var secret = getProperties().getProperty("jwt_secret_key");

        var hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());
        var now = Instant.now();
        return Jwts.builder()
                .claim("name", user.getFullName())
                .claim("email", user.getEmail())
                .setSubject(user.getEmail())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1L, ChronoUnit.HOURS)))
                .signWith(hmacKey)
                .compact();
    }

    private void validateUser(User user) throws RuntimeException {
        if (Utility.isInvalidEmail(user.getEmail())) throw new RuntimeException("Invalid email");
        if (Utility.isInvalidPassword(user.getPassword())) throw new RuntimeException("Invalid password");
        if (Utility.isEmpty(user.getName())) throw new RuntimeException("Invalid name");
        if (Utility.isEmpty(user.getType()) && !Type.types.contains(user.getType()))
            throw new RuntimeException("Invalid type");
    }

    private String generateOTP() {
        var rand = new SecureRandom();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int digit = rand.nextInt(10); // Generate a random integer between 0 and 9
            otp.append(digit); // Add the digit to the OTP string
        }

        return otp.toString();
    }

    private UserEntity getSingleUser(Query<UserEntity> query) {
        try {
            return (UserEntity) query.getSingleResult();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    private AuthenticationEntity getSingleAuthenticationEntity(Query<AuthenticationEntity> query) {
        try {
            return (AuthenticationEntity) query.getSingleResult();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }
}
