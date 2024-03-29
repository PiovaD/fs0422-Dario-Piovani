package catalogoBibliotecario;

import java.time.Year;

public abstract class Catalog {
	private static int ISBNId = 0;

	private int ISBN;
	private String title;
	private Year publicationYear;
	private int pageNumber;

	public Catalog(String title, int publicationYear, int pageNumber) {
		this.setISBN();
		this.setTitle(title);
		this.setPublicationYear(publicationYear);
		this.setPageNumber(pageNumber);
	}

	protected Catalog(int _ISBN, String title, int publicationYear, int pageNumber) {
		this(title, publicationYear, pageNumber);
		this.setISBNId(_ISBN);

	}

	public int getISBN() {
		return ISBN;
	}

	private void setISBN() {
		this.ISBN = ISBNId++;
	}

	private void setISBNId(int _ISBN) {
		if (ISBNId < _ISBN)
			ISBNId = _ISBN;
		this.ISBN = _ISBN;
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

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public abstract String forDiskString();

}
