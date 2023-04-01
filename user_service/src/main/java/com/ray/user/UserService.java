package com.ray.user;

import com.ray.user.entity.UserEntity;
import com.ray.user.entity.UserEntityRole;
import com.ray.user.grpc.Authentication;
import com.ray.user.grpc.User;
import com.ray.user.util.hibernate.EntityService;
import com.ray.user.util.hibernate.HibernateUtil;
import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.Optional;

public class UserService {
    private static final Logger LOG = LogManager.getLogger(UserService.class);
    private static final EntityService<UserEntity> userService = new EntityService<>(UserEntity.class);
    public Optional<Authentication> login(User user) {
        try (Session session = HibernateUtil.getSession()) {
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }
}
