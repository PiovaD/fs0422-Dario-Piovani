package catalogoBibliotecario;

import javax.persistence.Entity;

/*
I libri hanno inoltre:
- Autore
- Genere
*/

@Entity
public class Book extends Catalog {

	private String author;
	private String genre;

	public Book() {
	}
	
	public Book(String isbn, String title, int publicationYear, int pageNumber, String author, String genre) {
		super(isbn, title, publicationYear, pageNumber);
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
	public String toString() {
		return "Libro [ codice ISBN: " + super.getISBN() + ", titolo: " + super.getTitle()
				+ ", Anno di pubblicazione: " + super.getPublicationYear() + ", N° di pagine: " + super.getPageNumber()
				+ ", autore: " + this.getAuthor() + ", genere: " + this.getGenre() + " ]";
	}

}
