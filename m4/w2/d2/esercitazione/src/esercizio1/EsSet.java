package esercizio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EsSet {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int elemQuantita = 0;
		Set<String> hSet = new HashSet<>();

		ArrayList<String> duplicate = new ArrayList<>();

		while (true) {
			System.out.printf("Quante parole vuoi inserire? ");

			try {
				elemQuantita = Integer.parseInt(in.nextLine());
				break;
			} catch (NumberFormatException exc) {
				System.out.println(exc.getMessage() + " inserisci un intero");
			}
		}

		for (int i = 0; i < elemQuantita; i++) {
			System.out.printf("Inserisci parola: ");
			String p = in.nextLine();
			if (!hSet.add(p))
				duplicate.add(p);
		}

		System.out.println("Duplicati " + duplicate);

		System.out.println("Numero parole distinte: " + hSet.size());

		System.out.println("Parole distinte: " + hSet);

		in.close();
		System.out.println("THE END");

	}

}
