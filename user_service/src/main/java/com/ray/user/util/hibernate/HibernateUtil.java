package com.ray.user.util.hibernate;

import com.ray.user.entity.AuthenticationEntity;
import com.ray.user.entity.UserEntity;
import com.ray.user.entity.UserEntityRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
    private static SessionFactory sessionFactory;
    private HibernateUtil() {}

    public static Session getSession() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory.openSession();
    }


    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(UserEntity.class);
        configuration.addAnnotatedClass(UserEntityRole.class);
        configuration.addAnnotatedClass(AuthenticationEntity.class);

        return configuration.buildSessionFactory();
    }
}