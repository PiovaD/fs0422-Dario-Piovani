package es3;

import java.util.Scanner;

public class Esercizio3 {

	public static void main(String[] args) {

		String str = "";
		Scanner in = new Scanner(System.in);

		System.out.println("Inserisci stringa: ");
		str = in.nextLine();

		while (!str.equals(":q")) {

			// String newStr = str.replaceAll("", ",");

			String[] newStr = str.split("");

			for (String ch : newStr) {
				System.out.printf(ch + ",");
			}
			System.out.println();
			System.out.println("Inserisci stringa: ");
			str = in.nextLine();
		}

		System.out.println("the end");
	}

}
