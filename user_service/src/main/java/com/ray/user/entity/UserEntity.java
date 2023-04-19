package com.ray.user.entity;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.google.protobuf.ByteString;
import com.ray.user.grpc.User;
import com.ray.user.grpc.UserRole;
import com.ray.user.util.Role;
import com.ray.user.util.Status;
import com.ray.user.util.Type;
import com.ray.user.util.Utility;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @Column
    private String phone;
    @Column
    private String gender;
    @Column
    private String nationality;
    @Column
    private String address;
    @Column
    private String passportNo;
    @Column
    private String type;
    @Column
    private String otp;
    @Column
    private String status;
    @Column
    private String fileName;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] profilePicture;
    @Column
    private String contentType;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<UserEntityRole> roles = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserEntityRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserEntityRole> roles) {
        this.roles = roles;
    }

    public String getFullName() {
        return name;
    }

    public static User getUser(UserEntity user, boolean loadImage) {
        var userBuilder = User.newBuilder()
                .setAddress(user.address)
                .setName(user.name)
                .setEmail(user.email)
                .setPassportNo(user.passportNo)
                .setPhone(user.phone)
                .setGender(user.gender)
                .setNationality(user.nationality)
                .setType(user.type)
                .setStatus(user.status);
        for (var role : user.roles) {
            userBuilder.addRoles(UserEntityRole.getUserRole(role));
        }
        if (loadImage) {
            userBuilder.setFileName(user.fileName)
                    .setContentType(user.contentType)
                    .setProfilePicture(ByteString.copyFrom(user.profilePicture));
        }
        return userBuilder.build();
    }

    public static UserEntity getInstance(User user) {
        var entity = new UserEntity();
        entity.status = user.getStatus();
        entity.contentType = user.getContentType();
        entity.fileName = user.getFileName();
        entity.address = user.getAddress();
        entity.gender = user.getGender();
        entity.nationality = user.getNationality();
        entity.email = user.getEmail();
        entity.name = user.getName();
        entity.passportNo = user.getPassportNo();
        entity.phone = user.getPhone();
        entity.otp = user.getOtp();
        entity.type = user.getType();
        entity.password = user.getPassword();
        entity.profilePicture = user.getProfilePicture().toByteArray();
        entity.roles = user.getRolesList().stream()
                .map(UserEntityRole::getInstance)
                .collect(Collectors.toList());
        entity.createdAt = LocalDateTime.now();
        return entity;
    }

    public static void updateInstance(User user, UserEntity savedUser) {
        savedUser.status = Status.statuses.contains(user.getStatus()) ? user.getStatus() : savedUser.status;
        savedUser.address = Utility.isEmpty(user.getAddress()) ? savedUser.getAddress() : user.getAddress();
        savedUser.gender = Utility.isEmpty(user.getGender()) ? savedUser.gender : user.getGender();
        savedUser.nationality = Utility.isEmpty(user.getNationality()) ? savedUser.nationality : user.getNationality();
        savedUser.name = Utility.isEmpty(user.getName()) ? savedUser.name : user.getName();
        savedUser.passportNo = Utility.isEmpty(user.getPassportNo()) ? savedUser.passportNo : user.getPassportNo();
        savedUser.phone = Utility.isEmpty(user.getPhone()) ? savedUser.phone : user.getPhone();
        savedUser.type = Type.types.contains(user.getType()) ? user.getType() : savedUser.type;
        if (!Utility.isInvalidPassword(user.getPassword())) {
            savedUser.password = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        }
        var roles = savedUser.roles.stream()
                .map(UserEntityRole::getRole)
                .collect(Collectors.toList());

        savedUser.roles.addAll(user.getRolesList().stream()
                .map(UserRole::getRole)
                .filter(Role.roles::contains)
                .filter(roles::contains)
                .map(UserEntityRole::new)
                .collect(Collectors.toList()));

        if (!Utility.isEmpty(user.getFileName()) && !user.getFileName().equals(savedUser.fileName)) {
            savedUser.contentType = user.getContentType();
            savedUser.fileName = user.getFileName();
            savedUser.profilePicture = user.getProfilePicture().toByteArray();
        }
        savedUser.updatedAt = LocalDateTime.now();
    }
}