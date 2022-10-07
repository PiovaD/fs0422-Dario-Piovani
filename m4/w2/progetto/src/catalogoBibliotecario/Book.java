package catalogoBibliotecario;

public class Book extends Catalog {

	private String author;
	private String genre;

	public Book(String title, int publicationYear, int pageNumber, String author, String genre) {
		super(title, publicationYear, pageNumber);
		this.setAuthor(author);
		this.setGenre(genre);
	}
	
	protected Book(int ISBN, String title, int publicationYear, int pageNumber, String author, String genre) {
		super(ISBN, title, publicationYear, pageNumber);
		this.setAuthor(author);
		this.setGenre(genre);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String forDiskString() {
		return "libro[ISBN:" + this.getISBN() + ",t:" + this.getTitle() + ",A:" + this.getPublicationYear() + ",p:"
				+ this.getPageNumber() + ",aut:" + this.getAuthor() + ",g:" + this.getGenre() + "]";
	}

	@Override
	public String toString() {
		return "Libro [ codice ISBN: " + this.getISBN() + ", titolo: " + this.getTitle() + ", Anno di pubblicazione: "
				+ this.getPublicationYear() + ", N° di pagine: " + this.getPageNumber() + ", autore: "
				+ this.getAuthor() + ", genere: " + this.getGenre() + " ]";
	}

}
