package models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Concerto;
import models.Evento;
import models.GenereConcerto;
import utils.JpaUtil;
import utils.LogColor;

public class EventoDAO {
	private static final Logger logger = LoggerFactory.getLogger(EventoDAO.class);

	public static void save(Evento obj) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			EntityTransaction t = em.getTransaction();

			t.begin();

			em.persist(obj);

			t.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.RED("Errore di salvataggio Evento:  " + obj.getClass()
					.getSimpleName()), ex);
		} finally {
			em.close();
		}

	}

	public static Evento getById(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {

			return em.find(Evento.class, id);

		} finally {
			em.close();
		}

	}

	public static void delete(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(em.find(Evento.class, id));

			t.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.RED("Errore cancellazione Evento: " + id), ex);

		} finally {
			em.close();
		}

	}

	public static void refresh(Evento obj) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			em.refresh(obj);

		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.RED("Error refreshing Evento: " + obj.getClass()
					.getSimpleName()), ex);

		} finally {
			em.close();
		}

	}

	public static List<Concerto> getConcertiInStreaming(boolean isStreaming) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {

			Query q = em.createNamedQuery("getIsStreaming");

			q.setParameter("isSt", isStreaming);

			return q.getResultList();

		} catch (Exception e) {
			logger.error(LogColor.RED(e.getMessage()));
		}
		finally {
			em.close();
		}

		return null;
	}

	public static List<Concerto> getConcertiPerGenere(GenereConcerto genere) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			Query q = em.createNamedQuery("getConcertGenre");

			q.setParameter("genere", genere); 

			return q.getResultList();

		} catch (Exception e) {
			logger.error(LogColor.RED(e.getMessage()));
		}
		finally {
			em.close();
		}
		return null;
	}
}
