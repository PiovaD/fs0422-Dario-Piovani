package es2;

import java.util.Scanner;

public class Esercizio2 {

	public static void main(String[] args) {

		String again = "s";
		Scanner in = new Scanner(System.in);

		do {
			System.out.printf("Inserisci intero compreso da 0a 3 per riceverlo in formato letterale: ");
			int num = in.nextInt();

			switch (num) {
			case 0:
				System.out.println("zero");
				break;
			case 1:
				System.out.println("uno");
				break;
			case 2:
				System.out.println("due");
				break;
			case 3:
				System.out.println("tre");
				break;
			default:
				System.out.println("numero errato");
			}

			System.out.printf("Continuare: s/n ");
			again = in.nextLine();
			again = in.nextLine();

		} while (again.equals("s"));

		System.out.println("the end");
	}
}
