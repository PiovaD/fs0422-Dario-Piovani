package catalogoBibliotecario;

import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

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

	/**
	 * Inserisci il numero senza gli eventuali zero frontali
	 * */
	public Catalog find(int NoZeroISBN) {

		Catalog found = this.archive.get(NoZeroISBN);
		
		try {
			if (found == null) {
				throw new ArchiveException("Elemento non trovato");
			}
		} catch (ArchiveException e) {
			System.out.println(e.getLocalizedMessage());

		}
		return found;
	}

	public Map<Integer, Catalog> find(Year year) {

		return this.archive.values()
				.stream()
				.filter((c) -> c.getPublicationYear()
						.equals(year))
				.collect(Collectors.toMap(c -> c.getISBN(), c -> c));
	}

	public Map<Integer, Catalog> find(String author) {

		return this.archive.values()
				.stream()
				.filter(c -> c instanceof Book)
				.map(c -> (Book) c)
				.filter(m -> m.getAuthor()
						.toLowerCase()
						.equals(author.toLowerCase()))
				.collect(Collectors.toMap(c -> c.getISBN(), c -> c));
	}

	public void saveOnDisk(String path) throws IOException {
		File file = new File(path);
		final String encoding = "UTF-8";

		FileUtils.writeStringToFile(file, "", encoding);
		FileUtils.writeStringToFile(file, archiveToString(), encoding, true);

	}

	// caricamento da disco e i suoi sotto metodi
	public boolean loadByDisk(String path) throws IOException {
		File file = new File(path);
		final String encoding = "UTF-8";

		String contentString = FileUtils.readFileToString(file, encoding);
		if (!contentString.isEmpty()) {

			this.fillArchive(contentString);

			return true;
		}

		return false;
	}

	private String archiveToString() {
		String s = "";

		for (Map.Entry<Integer, Catalog> entry : this.archive.entrySet()) {
			s += entry.getValue()
					.forDiskString();
		}

		return s;

	}

	private void fillArchive(String content) {

		String[] splittedContent = content.split("]");

		for (String cat : splittedContent) {

			String[] tmp = cat.split("\\[");

			if (tmp[0].toLowerCase()
					.equals("rivista")) {
				addMegazine(splitData(tmp[1]));

			} else if (tmp[0].toLowerCase()
					.equals("libro")) {
				addBook(splitData(tmp[1]));

			} else {
				System.err.println("Dato errato: lettura impossibile");
			}

		}

	}

	private ArrayList<String> splitData(String data) {

		ArrayList<String> splitted = new ArrayList<String>();
		String[] tmpSplitStrings = data.split(",");

		for (String s : tmpSplitStrings) {
			splitted.add((s.split(":"))[1]);
		}

		return splitted;
	}

	private void addBook(ArrayList<String> data) {

		if (data.size() == 6)

			this.add(new Book(Integer.parseInt(data.get(0)), data.get(1), Integer.parseInt(data.get(2)),
					Integer.parseInt(data.get(3)), data.get(4), data.get(5)));
		else
			System.err.println("Errore elaborazione dati " + data.toString());

	}

	private void addMegazine(ArrayList<String> data) {

		if (data.size() == 5)

			this.add(new Magazine(Integer.parseInt(data.get(0)), data.get(1), Integer.parseInt(data.get(2)),
					Integer.parseInt(data.get(3)), Periodicity.valueOf(data.get(4))));

		else
			System.err.println("Errore elaborazione dati " + data.toString());

	}

}

@SuppressWarnings("serial")
class ArchiveException extends Exception {

	public ArchiveException(String message) {
		super(message);
	}
}
