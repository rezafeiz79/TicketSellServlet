package com.reza.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Set;

public class DatabaseUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static <T> Set<T> getAllEntities(Session session, Class<T> type) {
        Set<T> set = new HashSet<T>();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
        Root<T> rootEntry = criteriaQuery.from(type);
        CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
        TypedQuery<T> allQuery = session.createQuery(all);
        set.addAll(allQuery.getResultList());
        return set;
    }

    public static <T> void saveEntity(Session session, T object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public static <T> T getEntityById(Session session, int id, Class<T> type) {
        return (T)session.get(type, id);
    }

    public static <T> void deleteEntity(Session session, T object) {
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    public static <T> void updateEntity(Session session, T object) {
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}