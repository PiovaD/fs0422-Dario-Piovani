package esercizio3;

public class HMap {
	public static void main(String[] args) {
		Rubrica r1 = new Rubrica();

		r1.addPerson("Mario", 1215151055);
		r1.addPerson("Malario", 1215134410);
		r1.addPerson("Wario", 121435104);
		r1.addPerson("Carlo", 1215143204);

		r1.addPerson("Carlo", 1215143204);

		System.out.println(r1.removePerson("Malario") ? "Rimosso" : "Non trovato");
		
		System.out.printf("Riusltato ricerca per numero: %n" + r1.findPerson(1215143204) + "%n");
		
		System.out.printf("Riusltato ricerca per nome: %n" + r1.findPerson("Mario") + "%n");
		
		
		System.out.println("-----------------------------------------------");

		r1.print();
	}
}
