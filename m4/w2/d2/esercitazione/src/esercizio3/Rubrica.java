package esercizio3;

import java.util.HashMap;
import java.util.Map;

public class Rubrica {

	private Map<String, Integer> rubric = new HashMap<>();

	public Rubrica() {
	}

	public void addPerson(String name, int number) {
		if (rubric.containsKey(name)) System.err.println("Nome già esistente");
		this.rubric.put(name, number);
	}

	public boolean removePerson(String name) {
		return this.rubric.remove(name) == null ? false : true;
	}

	public String findPerson(int number) {

		return rubric.containsValue(number) ? "Nome: " + returnKey(number) + " Numero: " + number : "non trovato";
	}

	public String findPerson(String name) {

		return rubric.containsKey(name) ? "Nome: " + name + " Numero: " + rubric.get(name).toString() : "non trovato";
	}

	private String returnKey(int number) {

		for (Map.Entry<String, Integer> entry : rubric.entrySet()) {
			if (entry.getValue().equals(number)) {
				return entry.getKey();
			}
		}

		return "";
	}

	public void print() {
		for (Map.Entry<String, Integer> mEntry : rubric.entrySet()) {
			System.out.print("Nome: " + mEntry.getKey() + " Numero: ");
			System.out.println(mEntry.getValue());
		}
	}
}
