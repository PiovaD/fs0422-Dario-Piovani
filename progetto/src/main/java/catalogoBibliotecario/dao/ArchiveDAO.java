package catalogoBibliotecario.dao;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import catalogoBibliotecario.Book;
import catalogoBibliotecario.Catalog;
import catalogoBibliotecario.prestito.Loan;
import catalogoBibliotecario.prestito.User;
import utils.JpaUtil;
import utils.LogColor;

public class ArchiveDAO {

	private static final Logger logger = LoggerFactory.getLogger(ArchiveDAO.class);

	// Ricerca per ISBN
	public static Catalog findByIsbn(String ISBN) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Catalog> cq = cb.createQuery(Catalog.class);

			Root<Catalog> catRoot = cq.from(Catalog.class);

			Predicate pd1 = cb.like(catRoot.get("ISBN"), ISBN);

			cq.select(catRoot)
					.where(pd1);

			Query q = em.createQuery(cq);

			Catalog elem = (Catalog) q.getSingleResult();

			return elem;
		} catch (NoResultException e) {
			logger.error(LogColor.RED("ISBN not found, ") + e.getLocalizedMessage());

		} catch (Exception e) {
			logger.error(LogColor.RED("ISBN find error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}

		return null;
	}

	// Ricerca per anno pubblicazione
	public static List<Catalog> findByPublicationYear(int year) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		Year yearPub = Year.of(year);
		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Catalog> cq = cb.createQuery(Catalog.class);

			Root<Catalog> catRoot = cq.from(Catalog.class);

			Predicate pd1 = cb.equal(catRoot.get("publicationYear"), yearPub);

			cq.select(catRoot)
					.where(pd1);

			Query q = em.createQuery(cq);

			List<Catalog> elem = q.getResultList();

			return elem;

		} catch (NoResultException e) {
			logger.error(LogColor.RED("Year not found, ") + e.getLocalizedMessage());

		} catch (Exception e) {
			logger.error(LogColor.RED("Year find error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}

		return null;
	}

	// Ricerca per autore
	public static List<Book> findByAuthor(String author) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Catalog> cq = cb.createQuery(Catalog.class);

			Root<Book> bookRoot = cq.from(Book.class);

			Predicate pd1 = cb.like(bookRoot.get("author"), author);

			cq.select(bookRoot)
					.where(pd1);

			Query q = em.createQuery(cq);

			List<Book> elem = q.getResultList();

			return elem;

		} catch (NoResultException e) {
			logger.error(LogColor.RED("Author not found, ") + e.getLocalizedMessage());

		} catch (Exception e) {
			logger.error(LogColor.RED("Author find error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}

		return null;
	}

	// Ricerca per titolo o parte di esso
	public static List<Catalog> findByTitle(String title) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Catalog> cq = cb.createQuery(Catalog.class);

			Root<Catalog> bookRoot = cq.from(Catalog.class);

			Predicate pd1 = cb.like(bookRoot.get("title"), "%" + title + "%");

			cq.select(bookRoot)
					.where(pd1);

			Query q = em.createQuery(cq);

			List<Catalog> elem = q.getResultList();

			return elem;
		} catch (NoResultException e) {
			logger.error(LogColor.RED("Title not found, ") + e.getLocalizedMessage());

		} catch (Exception e) {
			logger.error(LogColor.RED("Title find error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}

		return null;
	}

	// Ricerca degli elementi attualmente in prestito dato un numero di tessera
	// utente
	public static List<Loan> currentlyLoanItemsByLibCard(String idCard) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		User user = UserDAO.findByCaredId(idCard);

		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Catalog> cq = cb.createQuery(Catalog.class);

			Root<Loan> loanRoot = cq.from(Loan.class);

			Predicate pd1 = cb.equal(loanRoot.get("user"), user.getId());
			Predicate pd2 = cb.isNull(loanRoot.get("effectiveReturn"));

			cq.select(loanRoot.get("loanedElem"))
					.where(cb.and(pd1, pd2));

			Query q = em.createQuery(cq);

			List<Loan> elem = q.getResultList();

			return elem;
		} catch (NoResultException e) {
			logger.error(LogColor.RED("list not found, ") + e);

		} catch (Exception e) {
			logger.error(LogColor.RED("Current Loan find error: ") + e);

		} finally {
			em.close();
		}

		return null;
	}

	// Ricerca di tutti i prestiti scaduti e non ancora restituiti
	public static List<Loan> findOffLoans() {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Catalog> cq = cb.createQuery(Catalog.class);

			Root<Loan> loanRoot = cq.from(Loan.class);

			Predicate pd1 = cb.isNull(loanRoot.get("effectiveReturn"));
			Predicate pd2 = cb.lessThan(loanRoot.get("expectedReturn"), LocalDate.now());

			cq.select(loanRoot.get("loanedElem"))
					.where(cb.and(pd1,pd2));

			Query q = em.createQuery(cq);

			List<Loan> elem = q.getResultList();

			return elem;
		} catch (NoResultException e) {
			logger.error(LogColor.RED("list not found, ") + e);

		} catch (Exception e) {
			logger.error(LogColor.RED("Find off Loan find error: ") + e);

		} finally {
			em.close();
		}

		return null;

	}

	public static List<Loan> LoanItemsByLibCard(String idCard) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		User user = UserDAO.findByCaredId(idCard);

		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Loan> cq = cb.createQuery(Loan.class);

			Root<Loan> loanRoot = cq.from(Loan.class);

			Predicate pd1 = cb.equal(loanRoot.get("user"), user.getId());

			cq.select(loanRoot).where(pd1);

			Query q = em.createQuery(cq);

			List<Loan> elem = q.getResultList();

			return elem;
		} catch (NoResultException e) {
			logger.error(LogColor.RED("list not found, ") + e);

		} catch (Exception e) {
			logger.error(LogColor.RED("Loan by Id find error: ") + e);

		} finally {
			em.close();
		}

		return null;
	}

}
