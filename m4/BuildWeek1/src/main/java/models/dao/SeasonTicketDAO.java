package models.dao;


import models.SeasonTicket;
import models.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class SeasonTicketDAO {

    private static final Logger logger = LoggerFactory.getLogger(SeasonTicketDAO.class);

    public static void save(SeasonTicket object) {
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

    public void refresh(SeasonTicket object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh(object);

        } finally {
            em.close();
        }

    }

    public static SeasonTicket getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.find(SeasonTicket.class, id);

        } finally {
            em.close();
        }

    }

    public static void delete(SeasonTicket object) {
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

    public static List<SeasonTicket> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.createQuery("select p from SeasonTicket p").getResultList();

        } finally {
            em.close();
        }
    }

    public List<SeasonTicket> getSeasonTicketByReseller(Long id){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        try {

            Query query = em.createQuery("select p from SeasonTicket p where p.reseller.id = :id");

            query.setParameter( "id", id );
            return query.getResultList();

        } finally {
            em.close();
        }

    }
}
