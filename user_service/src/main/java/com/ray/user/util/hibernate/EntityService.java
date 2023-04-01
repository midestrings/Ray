package com.ray.user.util.hibernate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class EntityService<T> {
    private final Class<T> clazz;

    public EntityService(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T save(T entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public T update(T entity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        T savedEntity = session.merge(entity);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return savedEntity;
    }

    public Optional<T> getById(Integer id) {
        Session session = HibernateUtil.getSession();
        T entity = session.get(clazz, id);
        session.close();
        return entity != null ? Optional.of(entity) : Optional.empty();
    }
    public List<T> getAll() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(clazz);
        criteria.from(clazz);
        List<T> list = session.createQuery(criteria).getResultList();
        session.close();
        return list != null ? list : new LinkedList<>();
    }
}
