package catalogoBibliotecario.prestito;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import catalogoBibliotecario.Catalog;

/*
Il prestito è caratterizzato da:
- Utente 
- Elemento prestato (può essere un libro o una rivista)
- Data inizio prestito
- Data restituzione prevista (calcolata automaticamente a 30 gg dalla data inizio prestito)
- Data restituzione effettiva

 */

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private User user;

	@ManyToOne
	@JoinColumn(name = "catalog_id")
	private Catalog loanedElem; // (può essere un libro o una rivista)

	private LocalDate startLoan;
	private LocalDate expectedReturn; // (calcolata automaticamente a 30 gg dalla data inizio prestito)

	private LocalDate effectiveReturn;

	public Loan() {
	}

	public Loan(User user, Catalog loanedElem, LocalDate startLoan) {
		this.user = user;
		this.loanedElem = loanedElem;
		this.startLoan = startLoan;
		this.expectedReturn = startLoan.plusDays(30);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Catalog getLoanedElem() {
		return loanedElem;
	}

	public void setLoanedElem(Catalog loanedElem) {
		this.loanedElem = loanedElem;
	}

	public LocalDate getExpectedReturn() {
		return expectedReturn;
	}

	public void setExpectedReturn(LocalDate expectedReturn) {
		this.expectedReturn = expectedReturn;
	}

	public LocalDate getEffectiveReturn() {
		return effectiveReturn;
	}

	public void setEffectiveReturn(LocalDate effectiveReturn) {
		this.effectiveReturn = effectiveReturn;
	}

	public long getId() {
		return id;
	}

	public LocalDate getStartLoan() {
		return startLoan;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", user=" + user + ", loanedElem=" + loanedElem + ", startLoan=" + startLoan
				+ ", expectedReturn=" + expectedReturn + ", effectiveReturn=" + effectiveReturn + "]";
	}

	
}
