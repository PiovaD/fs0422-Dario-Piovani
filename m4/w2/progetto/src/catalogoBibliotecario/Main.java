package catalogoBibliotecario;

import java.io.IOException;
import java.time.Year;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	public static Logger logger = LoggerFactory.getLogger(Archive.class);

	private static final String path = "docs/archive";

	public static void sep(String msg) {
		System.out.printf("%n----------------%s----------------%n", msg);
	}

	public static void main(String[] args) {

		Archive a1 = new Archive();

		try {
			
			if (a1.loadByDisk(path)) {
				logger.info("Dati caricati dal file: " + path);
			} else {			
				IOException e = new IOException("Il file è vuoto carico i dati di default");
				throw e;
			}
			
		} catch (IOException e) {
			logger.error(e.getMessage() + " carico i dati di default");
			a1 = new Archive(ArchiveMaker.maker());
		}

		sep("Lista completa");
		a1.print();

		Catalog c1 = a1.find(5);
		Archive a2 = new Archive(a1.find("Autore 1"));
		Archive a3 = new Archive(a1.find(Year.of(2012)));

		a1.add(new Book("Viaggi su Andromeda", 2012, 543, "Ermanno Vivaldi", "Fantascienza"));
		a1.add(new Magazine("Il coding per tutti", 2015, 23, Periodicity.SETTIMANALE));

		sep("Rimozione");
		a1.remove(5);

		sep("Trova ISBN");
		System.out.println(c1);

		sep("Trova autore");
		a2.print();

		sep("Trova anno");
		a3.print();

		sep("Stampa finale");
		a1.print();

		try {
			a1.saveOnDisk(path);

		} catch (IOException e) {
			logger.error(e.getMessage());
		}

	}

}
