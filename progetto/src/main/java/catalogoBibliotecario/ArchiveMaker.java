package catalogoBibliotecario;

import java.util.Map;

public class ArchiveMaker {
	
	private static Catalog b1 = new Book("Libro 1", 2012, 963, "Autore 1", "Fantasy");
	private static Catalog b2 = new Book( "Libro 2", 2018, 763, "Autore 2", "Adventure");
	private static Catalog b3 = new Book( "Libro 3", 2020, 523, "Autore 3", "Dramatic");
	private static Catalog b4 = new Book( "Libro 4", 2010, 876, "Autore 1", "Adventure");
	private static Catalog b5 = new Book( "Libro 5", 2022, 126, "Autore 2", "Fantasy");
	private static Catalog b6 = new Book( "Libro 6", 2012, 903, "Autore 2", "Fantasy");
	private static Catalog m1 = new Magazine("Rivista 1", 2020, 23, Periodicity.MENSILE);
	private static Catalog m2 = new Magazine( "Rivista 2", 2012, 43, Periodicity.SETTIMANALE);
	private static Catalog m3 = new Magazine("Rivista 3", 2015, 51, Periodicity.SEMESTRALE);
	private static Catalog m4 = new Magazine( "Rivista 4", 2012, 22, Periodicity.MENSILE);
	private static Catalog m5 = new Magazine( "Rivista 5", 2022, 63, Periodicity.SETTIMANALE);
	

	public static Map<Integer, Catalog> maker(){
		
		Archive tmp = new Archive();

		tmp.add(b1);
		tmp.add(b2);
		tmp.add(b3);
		tmp.add(b4);
		tmp.add(b5);
		tmp.add(b6);

		tmp.add(m1);
		tmp.add(m2);
		tmp.add(m3);
		tmp.add(m4);
		tmp.add(m5);
		
		
		return tmp.getArchive();
	};

}
