package catalogoBibliotecario;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Archive {

	private Map<Integer, Catalog> archive = new HashMap<Integer, Catalog>();
	
	public Archive() {
	}
	
	public Archive(Map<Integer, Catalog> archive) {
		this.setArchive(archive);
	}

	public Map<Integer, Catalog> getArchive() {
		return archive;
	}

	public void setArchive(Map<Integer, Catalog> archive) {
		this.archive = archive;
	}

	public void print() {
		for (Map.Entry<Integer, Catalog> entry : this.archive.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
	
	public void add(Catalog catalog) {
		try {
			this.archive.put(catalog.getISBN(), catalog);
		} catch (Exception exc) {
			System.err.println("ERRORE: " + exc.getMessage());
		}
	}

	public void remove(int ISBN) {
		System.out.println(this.archive.remove(ISBN) != null ? "Rimozione riuscita" : "Rimozione non riuscita");
	}

	public Catalog find(int ISBN) {
		return this.archive.get(ISBN);
	}

	public Map<Integer, Catalog> find(Year year) {

		return this.archive.values()
				.stream()
				.filter((c) -> c
						.getPublicationYear().equals(year))
				.collect(Collectors.toMap(c -> c.getISBN(), c -> c));
	}
	
	public Map<Integer, Catalog> find(String author) {

		return this.archive.values()
				.stream()
				.filter(c -> c instanceof Book)
				.map(c -> (Book)c)
				.filter(m -> m.getAuthor().toLowerCase().equals(author.toLowerCase()))
				.collect(Collectors.toMap(c -> c.getISBN(), c -> c));
	}
	
}
