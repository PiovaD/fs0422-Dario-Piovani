package catalogoBibliotecario;

import java.time.Year;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import catalogoBibliotecario.prestito.Loan;

/*
*- Codice ISBN (codice univoco)
*- Titolo
*- Anno pubblicazione
*- Numero pagine
*/
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Catalog {

	@Id
	@SequenceGenerator(name = "catalog_seq", sequenceName = "catalog_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalog_seq")
	private long id;

	@Column(unique=true)
	private String ISBN;

	private String title;

	private Year publicationYear;

	private int pageNumber;
	
	@OneToMany(mappedBy = "loanedElem", cascade = CascadeType.ALL)
	private Set<Loan> loanSet;

	public Catalog() {
	}

	public Catalog(String ISBN, String title, int publicationYear, int pageNumber) {
		this.setTitle(title);
		this.setPublicationYear(publicationYear);
		this.setPageNumber(pageNumber);
		this.setISBN(ISBN);
	}

	public long getId() {
		return id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Year getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = Year.of(publicationYear);
	}
	
	public void setPublicationYear(Year publicationYear) {
		this.publicationYear = publicationYear;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}
