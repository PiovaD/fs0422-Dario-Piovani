package catalogoBibliotecario;

public class Magazine extends Catalog {

	private Periodicity periodicity;

	public Magazine(String title, int publicationYear, int pageNumber, Periodicity periodicity) {
		super(title, publicationYear, pageNumber);
		this.setPeriodicity(periodicity);
	}
	
	public Magazine(int ISBN, String title, int publicationYear, int pageNumber, Periodicity periodicity) {
		super(ISBN, title, publicationYear, pageNumber);
		this.setPeriodicity(periodicity);
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String forDiskString() {
		return "rivista[ISBN:" + this.getISBN() + ",t:" + this.getTitle() + ",A:" + this.getPublicationYear() + ",p:"
				+ this.getPageNumber() + ",period:" + this.getPeriodicity() + "]";
	}

	@Override
	public String toString() {
		return "Rivista [ codice ISBN: " + this.getISBN() + ", titolo: " + this.getTitle() + ", Anno di pubblicazione: "
				+ this.getPublicationYear() + ", N° di pagine: " + this.getPageNumber() + ", Periodicità: "
				+ this.getPeriodicity() + " ]";
	}

}
