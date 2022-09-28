package es3;

import java.util.Scanner;

public class Esercizio3 {

	public static void main(String[] args) {

		String str = "";
		Scanner in = new Scanner(System.in);

		System.out.println("Inserisci stringa: ");
		str = in.nextLine();

		while (!str.equals(":q")) {

			str = String.join(",", str.split("")); 
			System.out.println(str);
			
			System.out.println("Inserisci stringa: ");
			str = in.nextLine();
		}

		System.out.println("the end");
	}

}
