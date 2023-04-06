package com.ray.schedule.util.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static com.ray.schedule.ReservationServer.getProperties;

public final class HibernateUtil {
    private static final Logger LOG = LogManager.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;
    private static Session session;
    private HibernateUtil() {}

    public static Session getSession() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        session = sessionFactory.openSession();
        return session;
    }

    public static void closeSession() {
        try {
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
    }

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperties(getProperties());
//        configuration.addAnnotatedClass(VehicleCategoryEntity.class);

        return configuration.buildSessionFactory();
    }
}