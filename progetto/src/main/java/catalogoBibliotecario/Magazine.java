package catalogoBibliotecario;

import javax.persistence.Entity;

/*
 Le riviste hanno:
- Periodicità [SETTIMANALE, MENSILE, SEMESTRALE]
*/

@Entity
public class Magazine extends Catalog {

	private Periodicity periodicity;
	
	public Magazine() {
	}
	
	public Magazine(String isbn,String title, int publicationYear, int pageNumber, Periodicity periodicity) {
		super(isbn,title, publicationYear, pageNumber);
		this.setPeriodicity(periodicity);
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "Rivista [ codice ISBN: " + super.getISBN() + ", titolo: " + super.getTitle()
				+ ", Anno di pubblicazione: " + super.getPublicationYear() + ", N° di pagine: " + super.getPageNumber()
				+ ", Periodicità: " + this.getPeriodicity() + " ]";
	}

}
