package com.ray.user.util.hibernate;

import com.ray.user.entity.User;
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
        configuration.addAnnotatedClass(User.class);

        return configuration.buildSessionFactory();
    }
}