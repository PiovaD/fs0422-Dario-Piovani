package models.dao;

import models.SeasonTicket;
import models.Ticket;
import models.Voyage;
import utils.JpaUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.xml.xpath.XPathEvaluationResult.XPathResultType;

import java.time.LocalDate;
import java.util.List;

public class TicketDAO {

    private static final Logger logger = LoggerFactory.getLogger(TicketDAO.class);

    public static void save(Ticket object) {
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

    public static void refresh(Ticket object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh(object);

        } finally {
            em.close();
        }

    }

    public static Ticket getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.find(Ticket.class, id);

        } finally {
            em.close();
        }

    }

    public static void delete(Ticket object) {
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

    public static List<Ticket> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.createQuery("select p from Ticket p").getResultList();

        } finally {
            em.close();
        }
    }

    public List<Ticket> getTicketByReseller(Long id){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        try {

            Query query = em.createQuery("select p from Ticket p where p.reseller.id = :id");

            query.setParameter( "id", id );
            return query.getResultList();

        } finally {
            em.close();
        }

    }

    public static List<Ticket> getTicketByVehicle(Long vehicleId) {
    	
    	EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
    	
    	try {
    		CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
			
			Root<Ticket> TicketRoot = cq.from(Ticket.class);
			
			Predicate pd1 = cb.equal(TicketRoot.get("vehicle"), vehicleId);
			
			cq.select(TicketRoot).where(pd1);

			Query q = em.createQuery(cq);

			List<Ticket> itemList = q.getResultList();

			if(itemList.size() == 0) {
				System.out.println("No ticket found.");
			}
			
			return itemList;
			
		} catch (Exception e) {
			System.out.println("Errore ricerca ticket: " + e);
		}finally {
			
		}
    	
    	return null;
    }
    
public static List<Ticket> getTicketByTime(LocalDate startDate, LocalDate finishDate) {
    	
    	EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
    	
    	try {
    		CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class); //Select entita ticket
			
			Root<Ticket> TicketRoot = cq.from(Ticket.class); //From entita di ritorno
			
			Predicate pd1 = cb.between(TicketRoot.get("punch"), startDate, finishDate); // Where ticket.punch(nome proprietà)
			
			cq.select(TicketRoot).where(pd1); //query 

			Query q = em.createQuery(cq); // LAncio la query

			List<Ticket> itemList = q.getResultList(); // result

			if(itemList.size() == 0) {
				System.out.println("No ticket found.");
			}
			
			return itemList;
			
		} catch (Exception e) {
			System.out.println("Errore ricerca ticket: " + e);
		}finally {
			
		}
    	
    	return null;
    }

}
