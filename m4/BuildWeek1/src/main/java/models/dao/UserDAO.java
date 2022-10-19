package models.dao;


import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    public void save( User object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist(object);

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();

            logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }

    }

    public void refresh(User object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh(object);

        } finally {
            em.close();
        }

    }

    public User getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.find(User.class, id);

        } finally {
            em.close();
        }

    }

    public void delete(User object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(em.contains(object) ? object : em.merge(object));

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }

    }

    public void refreshName(User object, String name) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            User utente = em.find(object.getClass(), object.getId());

            em.getTransaction().begin();
            utente.setName( name );
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }

    public void refreshLastName(User object, String lastName) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            User utente = em.find(object.getClass(), object.getId());

            em.getTransaction().begin();
            utente.setLastName( lastName );
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }
    public List<User> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.createQuery("select p from User p").getResultList();

        } finally {
            em.close();
        }
    }

    public List<User> getUserByFullName(String name, String lastName) {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Query query = em.createNamedQuery( "userByFullName" );

            query.setParameter( "name", name );
            query.setParameter( "lastName", lastName );
            return query.getResultList();

        } finally {
            em.close();
        }
    }
}