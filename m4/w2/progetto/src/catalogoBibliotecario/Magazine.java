package catalogoBibliotecario;


public class Magazine extends Catalog {
	
	private Periodicity periodicity;
	

	public Magazine(String title, int publicationYear, int pageNumber, Periodicity periodicity) {
		super(title, publicationYear, pageNumber);
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
		return "Rivista [ codice ISBN: " + this.getISBN() + ", titolo: " + this.getTitle() + ", Anno di pubblicazione: " + this.getPublicationYear()
				+ ", N° di pagine: " + this.getPageNumber() + ", Periodicità: " + this.getPeriodicity() + " ]";
	}

}
