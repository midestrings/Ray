package com.ray.schedule.util.hibernate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EntityService<T> {
    private final Class<T> clazz;

    public EntityService(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void update(T entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(entity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    public Optional<T> getById(Integer id) {
        Session session = HibernateUtil.getSession();
        T entity = session.get(clazz, id);
        session.close();
        return entity != null ? Optional.of(entity) : Optional.empty();
    }
    public Stream<T> getAll(int limit) {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(clazz);
        criteria.from(clazz);
        Stream<T> stream = session.createQuery(criteria).setMaxResults(limit).getResultStream();
        return stream != null ? stream : Stream.of();
    }
}
