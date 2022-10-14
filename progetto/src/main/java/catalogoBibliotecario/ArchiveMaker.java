package catalogoBibliotecario;

import java.time.LocalDate;
import java.util.Random;

import catalogoBibliotecario.dao.ArchiveDAO;
import catalogoBibliotecario.dao.CatalogDAO;
import catalogoBibliotecario.dao.LoanDAO;
import catalogoBibliotecario.dao.UserDAO;
import catalogoBibliotecario.prestito.Loan;
import catalogoBibliotecario.prestito.User;

public class ArchiveMaker {

	private static Catalog b1 = new Book("88-4-2927-6255-6", "Libro 1", 2012, 963, "Autore 1", "Fantasy");
	private static Catalog b2 = new Book("88-4-6627-6255-6", "Libro 2", 2018, 763, "Autore 2", "Adventure");
	private static Catalog b3 = new Book("88-4-5665-1055-1", "Libro 3", 2020, 523, "Autore 3", "Dramatic");
	private static Catalog b4 = new Book("88-4-9855-8805-6", "Libro 4", 2010, 876, "Autore 1", "Adventure");
	private static Catalog b5 = new Book("88-4-9245-4137-2", "Libro 5", 2022, 126, "Autore 2", "Fantasy");
	private static Catalog b6 = new Book("88-4-1788-5934-8", "Libro 6", 2012, 903, "Autore 2", "Fantasy");
	private static Catalog m1 = new Magazine("88-2-7637-2329-6", "Rivista 1", 2020, 23, Periodicity.MENSILE);
	private static Catalog m2 = new Magazine("88-2-2225-9620-6", "Rivista 2", 2012, 43, Periodicity.SETTIMANALE);
	private static Catalog m3 = new Magazine("88-2-4554-8268-5", "Rivista 3", 2015, 51, Periodicity.SEMESTRALE);
	private static Catalog m4 = new Magazine("88-2-3978-9265-4", "Rivista 4", 2012, 22, Periodicity.MENSILE);
	private static Catalog m5 = new Magazine("88-2-9357-5924-8", "Rivista 5", 2022, 63, Periodicity.SETTIMANALE);

	private static User u1 = new User("Tristen", "Hjálmarr", LocalDate.of(1987,06,30), "0010256851");
	private static User u2 = new User("Wob", "Lugaid", LocalDate.of(2003,04,11), "0010256543");
	private static User u3 = new User("Laudine", "Chander", LocalDate.of(1984,12,19), "0010257854");
	private static User u4 = new User("Léana", "Manel", LocalDate.of(1988,05,20), "00102545852");
	
	private static Loan l1 = new Loan(UserDAO.findById(1L),ArchiveDAO.findByIsbn("88-4-6627-6255-6"),LocalDate.now().minusDays(2));
	private static Loan l2 = new Loan(UserDAO.findById(1L),ArchiveDAO.findByIsbn("88-4-9855-8805-6"),LocalDate.now().minusDays(1));
	private static Loan l3 = new Loan(UserDAO.findById(2L),ArchiveDAO.findByIsbn("88-2-7637-2329-6"),LocalDate.now().minusDays(7));
	private static Loan l4 = new Loan(UserDAO.findById(2L),ArchiveDAO.findByIsbn("88-2-3978-9265-4"),LocalDate.now().minusDays(8));
	private static Loan l5 = new Loan(UserDAO.findById(2L),ArchiveDAO.findByIsbn("88-2-9357-5924-8"),LocalDate.now().minusDays(5));
	private static Loan l6 = new Loan(UserDAO.findById(3L),ArchiveDAO.findByIsbn("88-4-9855-8805-6"),LocalDate.now().minusDays(10));
	private static Loan l7 = new Loan(UserDAO.findById(1L),ArchiveDAO.findByIsbn("88-2-9357-5924-8"),LocalDate.now());

	

	public static void maker() {

		CatalogDAO.add(b1);
		CatalogDAO.add(b2);
		CatalogDAO.add(b3);
		CatalogDAO.add(b4);
		CatalogDAO.add(b5);
		CatalogDAO.add(b6);

		CatalogDAO.add(m1);
		CatalogDAO.add(m2);
		CatalogDAO.add(m3);
		CatalogDAO.add(m4);
		CatalogDAO.add(m5);
		
		UserDAO.add(u1);
		UserDAO.add(u2);
		UserDAO.add(u3);
		UserDAO.add(u4);
				
//------Eseguire dopo la costruzione		
//		LoanDAO.add(l1);
//		LoanDAO.add(l2);
//		LoanDAO.add(l3);
//		LoanDAO.add(l4);
//		LoanDAO.add(l5);
//		LoanDAO.add(l6);
//		LoanDAO.add(l7);		

	};

}
