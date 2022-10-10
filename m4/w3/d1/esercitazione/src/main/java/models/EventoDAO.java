package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.JpaUtil;

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

			logger.error("Errore di salvataggio:  " + obj.getClass()
					.getSimpleName(), ex);
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

	public static void delete(Evento obj) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(obj);
			
			t.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error("Errore cancellazione evento: " + obj.getClass()
					.getSimpleName(), ex);

			throw ex;

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

			logger.error("Error refreshing object: " + obj.getClass()
					.getSimpleName(), ex);

			throw ex;
		} finally {
			em.close();
		}

	}

}
