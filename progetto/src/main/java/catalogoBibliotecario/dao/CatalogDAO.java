package catalogoBibliotecario.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import catalogoBibliotecario.Book;
import catalogoBibliotecario.Catalog;
import catalogoBibliotecario.Magazine;
import utils.JpaUtil;
import utils.LogColor;

public class CatalogDAO {
	private static final Logger logger = LoggerFactory.getLogger(ArchiveDAO.class);

	public static void add(Catalog catalog) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.persist(catalog);

			t.commit();

		} catch (EntityExistsException e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Add error, element alredy exist. ") + e.getLocalizedMessage());

		} catch (RollbackException e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Add error, commit fail (probably isbn alredy exist in db). ")
					+ e.getLocalizedMessage());

		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Add error: " + catalog) + e);

		} finally {
			em.close();
		}
	}

	public static void update(Magazine updateCatalog) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			Magazine oldCatalog = em.find(Magazine.class, updateCatalog.getId());

			oldCatalog.setISBN(updateCatalog.getISBN());
			oldCatalog.setPageNumber(updateCatalog.getPageNumber());
			oldCatalog.setPublicationYear(updateCatalog.getPublicationYear());
			oldCatalog.setTitle(updateCatalog.getTitle());
			oldCatalog.setPeriodicity(updateCatalog.getPeriodicity());

			em.flush();

			t.commit();

		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Remove error: ") + e.getLocalizedMessage());
		} finally {
			em.close();
		}
	}
	
	public static void update(Book updateCatalog) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			Book oldCatalog = em.find(Book.class, updateCatalog.getId());

			oldCatalog.setISBN(updateCatalog.getISBN());
			oldCatalog.setPageNumber(updateCatalog.getPageNumber());
			oldCatalog.setPublicationYear(updateCatalog.getPublicationYear());
			oldCatalog.setTitle(updateCatalog.getTitle());				
			oldCatalog.setAuthor(updateCatalog.getAuthor());
			oldCatalog.setGenre(updateCatalog.getGenre());
			
			em.flush();

			t.commit();

		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Remove error: ") + e.getLocalizedMessage());
		} finally {
			em.close();
		}
	}

	public static void remove(String ISBN) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			Catalog elem = ArchiveDAO.findByIsbn(ISBN);

			em.remove(em.find(Catalog.class, elem.getId()));

			t.commit();

			logger.info(LogColor.CYAN("Remove element from catalog with success"));

		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Remove error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}
	}

	public static Catalog getById(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			Catalog catalog = em.find(Catalog.class, id);

			return catalog;

		} catch (Exception e) {
			logger.error(LogColor.RED("Find catalog error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}
		return null;
	}

}
