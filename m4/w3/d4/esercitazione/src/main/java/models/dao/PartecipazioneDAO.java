package models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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

			logger.error(LogColor.RED("Errore di salvataggio Partecipazione:  " + obj.getClass()
					.getSimpleName()), ex);
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

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(em.find(Partecipazione.class, id));

			t.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.RED("Errore cancellazione Partecipazione: " + id), ex);

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

			logger.error(LogColor.RED("Error refreshing Partecipazione: "), ex);

		} finally {
			em.close();
		}

	}

	public static List<Object[]> getPartecipantiId(long idEvento){
		
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			Query q = em.createNativeQuery(
					"SELECT p.*\r\n"
					+ "FROM person AS p JOIN partecipation ON partecipation.id_person = p.id \r\n"
					+ "JOIN event AS e ON e.id = partecipation.id_event\r\n"
					+ "WHERE e.id = :ev_id"
					
//					"SELECT p.* "
//					+ "FROM person p "
//					+ "WHERE p.id  = ("
//					+ "SELECT part.id_person "
//					+ "FROM partecipation part "
//					+ "WHERE  part.id_event = :id_Ev )"
					);

			q.setParameter("ev_id", idEvento);

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
