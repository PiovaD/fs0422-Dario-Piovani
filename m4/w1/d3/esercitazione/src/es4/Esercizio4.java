package es4;

import java.util.Scanner;

public class Esercizio4 {
	public static void main(String[] args) {

		String again = "s";
		Scanner in = new Scanner(System.in);

		do {
			System.out.printf("Inserisci il numero per far partire il conto alla rovescia: ");
			int num = in.nextInt();

			for(int i = num; i >= 0 ; i-- ) {

				System.out.println(i);
			}
			

			System.out.printf("Continuare: s/n ");
			again = in.nextLine();
			again = in.nextLine();

		} while (again.equals("s"));

		System.out.println("the end");
	}
}
