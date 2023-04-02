package com.ray.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.ray.user.entity.AuthenticationEntity;
import com.ray.user.entity.UserEntity;
import com.ray.user.entity.UserEntityRole;
import com.ray.user.grpc.Authentication;
import com.ray.user.grpc.UserFilter;
import com.ray.user.grpc.User;
import com.ray.user.util.Role;
import com.ray.user.util.Type;
import com.ray.user.util.Utility;
import com.ray.user.util.Status;
import com.ray.user.util.email.EmailUtil;
import com.ray.user.util.hibernate.EntityService;
import com.ray.user.util.hibernate.HibernateUtil;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.ray.user.UserInfoServer.getProperties;

public class UserService {
    private static final Logger LOG = LogManager.getLogger(UserService.class);
    private static final EntityService<UserEntity> userService = new EntityService<>(UserEntity.class);
    private static final EntityService<AuthenticationEntity> authService = new EntityService<>(AuthenticationEntity.class);

    public Optional<User> createUser(User user) {
        try {
            validateUser(user);
            var userEntity = UserEntity.getInstance(user);

            var roles = new LinkedList<UserEntityRole>();
            roles.add(new UserEntityRole(Role.User_Client));
            if (Type.Vendor.equals(user.getType())) roles.add(new UserEntityRole(Role.User_Vendor));
            userEntity.setRoles(roles);
            userEntity.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
            userEntity.setOtp(generateOTP());
            userService.save(userEntity);
            EmailUtil.sendEmail("Verify your email", user.getEmail(),
                    String.format("Verify your email on the Ray app.\nHere is your one time passcode <strong>%s</strong>", userEntity.getOtp()));
            return Optional.of(UserEntity.getUser(userEntity, false));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public Optional<Authentication> login(User user) {
        if (Utility.isInvalidEmail(user.getEmail())) {
            return Optional.of(Authentication.newBuilder().setError("Enter valid email").build());
        }
        if (Utility.isInvalidPassword(user.getPassword())) {
            return Optional.of(Authentication.newBuilder().setError("Enter valid password").build());
        }
        try {
            var session = HibernateUtil.getSession();
            var savedUser = getUserByEmail(user.getEmail(), session).orElse(null);
            session.close();

            if (savedUser == null || !BCrypt.verifyer().verify(user.getPassword().toCharArray(), savedUser.getPassword()).verified) {
                return Optional.of(Authentication.newBuilder().setError("Invalid credentials").build());
            }

            if (Status.Unverified.equals(savedUser.getStatus())) {
                savedUser.setOtp(generateOTP());
                userService.update(savedUser);
                EmailUtil.sendEmail("Verify your email", user.getEmail(),
                    String.format("Verify your email on the Ray app.\nHere is your one time passcode <strong>%s</strong>", savedUser.getOtp()));
                return Optional.of(Authentication.newBuilder().setError("OTP").build());
            }

            return getAuthentication(savedUser);
        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public Optional<Authentication> refreshToken(Authentication auth) {
        if (StringUtil.isNullOrEmpty(auth.getRefreshToken())) {
            return Optional.of(Authentication.newBuilder().setError("Invalid refresh token").build());
        }
        try {
            var session = HibernateUtil.getSession();
            var query = session.createQuery("from Authentication auth join fetch auth.user where auth.refreshToken = :token", AuthenticationEntity.class)
                    .setParameter("token", auth.getRefreshToken());
            var savedAuth = (AuthenticationEntity) query.getSingleResult();
            session.close();

            if (savedAuth == null) return Optional.of(Authentication.newBuilder().setError("Invalid refresh token").build());
            if (LocalDate.from(Instant.now()).isAfter(savedAuth.getRefreshTokenExpiry())) {
                return Optional.of(Authentication.newBuilder().setError("Refresh token expired").build());
            }

            savedAuth.setToken(generateToken(savedAuth.getUser()));
            savedAuth.setRefreshTokenExpiry(LocalDate.from(Instant.now().plus(1L, ChronoUnit.YEARS)));
            authService.update(savedAuth);
            return Optional.of(AuthenticationEntity.getAuthentication(savedAuth));

        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public Optional<User> updateUser(User user) {
        try {
            validateUser(user);
            var session = HibernateUtil.getSession();
            var savedUser = getUserByEmail(user.getEmail(), session).orElseThrow();
            session.close();
            UserEntity.updateInstance(user, savedUser);
            userService.update(savedUser);
            return Optional.of(UserEntity.getUser(savedUser, false));
        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public Optional<User> getUser(User user) {
        if (Utility.isInvalidEmail(user.getEmail())) return Optional.empty();
        try (var session = HibernateUtil.getSession()) {
            var savedUser = getUserByEmail(user.getEmail(), session).orElseThrow();
            return Optional.of(UserEntity.getUser(savedUser, true));
        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public Optional<Authentication> activateUser(User user) {
        if (Utility.isInvalidEmail(user.getEmail())) {
            return Optional.of(Authentication.newBuilder().setError("Invalid Email").build());
        }
        try {
            var session = HibernateUtil.getSession();
            var savedUser = getUserByEmail(user.getEmail(), session).orElseThrow();
            session.close();
            if (!savedUser.getOtp().equals(user.getOtp())) {
                return Optional.of(Authentication.newBuilder().setError("Invalid OTP").build());
            }
            return getAuthentication(savedUser);

        } catch (Exception e) {
            HibernateUtil.closeSession();
            LOG.error(e.getMessage(), e);
        }
        return Optional.of(Authentication.newBuilder().setError("Verification error").build());
    }

    public List<User> getAllUsers (UserFilter filter) {
        return null;
    }

    private Optional<Authentication> getAuthentication(UserEntity savedUser) {
        var auth = new AuthenticationEntity();
        auth.setUser(savedUser);
        auth.setToken(generateToken(savedUser));
        auth.setRefreshToken(UUID.randomUUID().toString());
        auth.setRefreshTokenExpiry(LocalDate.from(Instant.now().plus(1L, ChronoUnit.YEARS)));
        authService.save(auth);
        return Optional.of(AuthenticationEntity.getAuthentication(auth));
    }

    private Optional<UserEntity> getUserByEmail(String email, Session session) {
        var query = session.createQuery("from User where email = :email and status in (:statuses)", UserEntity.class)
                .setParameter("email", email)
                .setParameter("statuses", Status.Unverified + "," + Status.Active);
        var savedUser = (UserEntity) query.getSingleResult();
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
        if (StringUtil.isNullOrEmpty(user.getFirstName())) throw new RuntimeException("Invalid name");
        if (StringUtil.isNullOrEmpty(user.getType()) && !Type.types.contains(user.getType()))
            throw new RuntimeException("Invalid type");
    }

    private String generateOTP() {
        var rand = new SecureRandom();
        return rand.ints()
                .limit(6)
                .collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)
                .toString();
    }
}
