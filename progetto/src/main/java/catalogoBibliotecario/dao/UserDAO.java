package catalogoBibliotecario.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import catalogoBibliotecario.Catalog;
import catalogoBibliotecario.prestito.User;
import utils.JpaUtil;
import utils.LogColor;

public class UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

	public static void add(User user) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.persist(user);

			t.commit();

		} catch (EntityExistsException e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Add user error, element alredy exist. ") + e.getLocalizedMessage());

		} catch (RollbackException e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Add user error, commit fail. ")
					+ e.getLocalizedMessage());

		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Add user error: " + user) + e);

		} finally {
			em.close();
		}
	}

	// TODO public static void update(Long id) {}
	
	public static void remove(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(em.find(User.class, id));
			;

			t.commit();

		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Remove user error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}
	}

	public static User findById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			User user = em.find(User.class, id);
		
			return user;
			
		} catch (Exception e) {
			logger.error(LogColor.RED("Find user error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}
		return null;
	}

	public static User findByCaredId(String cardId) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<User> cq = cb.createQuery(User.class);

			Root<User> userRoot = cq.from(User.class);

			Predicate pd1 = cb.like(userRoot.get("libraryCardId"), cardId);

			cq.select(userRoot)
					.where(pd1);

			Query q = em.createQuery(cq);

			User elem = (User) q.getSingleResult();

			return elem;
		} catch (NoResultException e) {
			logger.error(LogColor.RED("Card id not found, ") + e.getLocalizedMessage());

		} catch (Exception e) {
			logger.error(LogColor.RED("User by card id find error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}

		return null;
	}
}
