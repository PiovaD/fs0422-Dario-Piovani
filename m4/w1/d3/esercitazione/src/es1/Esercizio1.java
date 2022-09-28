package es1;

import java.util.Scanner;

public class Esercizio1 {
	public static void main(String[] args) {

		String again = "s";

		Scanner in = new Scanner(System.in);

		do {
			
			System.out.printf("Inserisci stringa per verificare se pari: ");
			String str = in.nextLine();
			if (stringaPariDispari(str)) {
				System.out.println("è pari");
			} else {
				System.out.println("è dispari");
			}

			System.out.printf("Inserisci anno per verificare se è bisestile: ");
			int year = in.nextInt();
			if (annoBisestile(year)) {
				System.out.println("è bisestile");
			} else {
				System.out.println("non è bisestile");
			}
			
			System.out.printf("Continuare: s/n ");
			again = in.nextLine();
			again = in.nextLine();

		} while (again.equals("s"));
		
		System.out.println("the end");
	}

	public static boolean stringaPariDispari(String str) {
		return str.length() % 2 == 0 ? true : false;
	}

	public static boolean annoBisestile(int year) {
	
		return ((year % 4 == 0) || (year % 100 == 0 && year % 400 == 0));
	}

}
