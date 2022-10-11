package models.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Partecipazione;
import utils.JpaUtil;
import utils.LogColor;

public class PartecipazioneDAO {

	private static final Logger logger = LoggerFactory.getLogger(EventoDAO.class);

	public static void save(Partecipazione obj) {

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

			logger.error(LogColor.ANSI_RED + "Errore di salvataggio Partecipazione:  " + obj.getClass()
					.getSimpleName() + LogColor.ANSI_RED, ex);
		} finally {
			em.close();
		}

	}

	public static Partecipazione getById(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			return em.find(Partecipazione.class, id);

		} finally {
			em.close();
		}

	}

	public static void delete(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		
		try {
			EntityTransaction t = em.getTransaction();

			t.begin();
			

			em.remove(em.find(Partecipazione.class, id));
			
			t.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.ANSI_RED + "Errore cancellazione Partecipazione: " + id + LogColor.ANSI_RED, ex);


		} finally {
			em.close();
		}

	}

	public static void refresh(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			em.refresh(em.find(Partecipazione.class, id));

		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.ANSI_RED + "Error refreshing Partecipazione: " + LogColor.ANSI_RED, ex);

		} finally {
			em.close();
		}

	}

}
