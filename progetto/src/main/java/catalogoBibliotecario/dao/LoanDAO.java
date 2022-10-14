package catalogoBibliotecario.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import catalogoBibliotecario.prestito.Loan;
import utils.JpaUtil;
import utils.LogColor;

public class LoanDAO {
	private static final Logger logger = LoggerFactory.getLogger(LoanDAO.class);

	public static void add(Loan loan) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();
			
			t.begin();
			
			em.persist(loan);

			t.commit();


		
		} finally {
			em.close();
		}
	}
	
	public static void update(Loan updateLoan) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			Loan oldLoan = em.find(Loan.class, updateLoan.getId());

			oldLoan.setEffectiveReturn(updateLoan.getEffectiveReturn());
			oldLoan.setExpectedReturn(updateLoan.getExpectedReturn());
			oldLoan.setLoanedElem(updateLoan.getLoanedElem());
			oldLoan.setUser(updateLoan.getUser());

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
	
	public static void remove(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(em.find(Loan.class, id));

			t.commit();
			
			logger.info(LogColor.CYAN("Remove loan with success"));

		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			logger.error(LogColor.RED("Remove loan error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}
	}
	
	public static Loan findById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			Loan loan = em.find(Loan.class, id);
		
			return loan;
			
		} catch (Exception e) {
			logger.error(LogColor.RED("Find loan error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}
		return null;
	}

}
