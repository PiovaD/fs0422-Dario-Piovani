package models.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Location;
import utils.JpaUtil;
import utils.LogColor;

public class LocationDAO {
	private static final Logger logger = LoggerFactory.getLogger(EventoDAO.class);

	public static void save(Location obj) {

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

			logger.error(LogColor.ANSI_RED + "Errore di salvataggio Location:  " + obj.getClass()
					.getSimpleName() + LogColor.ANSI_RED, ex);
		} finally {
			em.close();
		}

	}

	public static Location getById(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			return em.find(Location.class, id);

		} finally {
			em.close();
		}

	}

	public static void delete(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		
		try {
			EntityTransaction t = em.getTransaction();

			t.begin();
			

			em.remove(em.find(Location.class, id));
			
			t.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.ANSI_RED + "Errore cancellazione Location: " + id + LogColor.ANSI_RED, ex);


		} finally {
			em.close();
		}

	}

	public static void refresh(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			em.refresh(em.find(Location.class, id));

		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.ANSI_RED + "Error refreshing Location: " + LogColor.ANSI_RED, ex);

		} finally {
			em.close();
		}

	}

}
