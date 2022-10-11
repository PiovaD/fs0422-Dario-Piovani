package models.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Evento;
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

			logger.error(LogColor.ANSI_RED + "Errore di salvataggio Evento:  " + obj.getClass()
					.getSimpleName() + LogColor.ANSI_RED, ex);
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

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		
		try {
			EntityTransaction t = em.getTransaction();

			t.begin();
			

			em.remove(em.find(Evento.class, id));
			
			t.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.ANSI_RED + "Errore cancellazione Evento: " + id + LogColor.ANSI_RED, ex);


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

			logger.error(LogColor.ANSI_RED + "Error refreshing Evento: " + obj.getClass()
					.getSimpleName() + LogColor.ANSI_RED, ex);

		} finally {
			em.close();
		}

	}

}
