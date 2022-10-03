package m1w2d1;

import java.util.Scanner;

public class Day1_3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int x = 0, y = 0;

		System.out.println("dammi x: ");

		try {
			x = Integer.parseInt(in.nextLine());
		} catch (NumberFormatException exc) {

			System.out.println("Dammi un numero intero!");
		}

		System.out.println("dammi y: ");
		
		try {
			y = Integer.parseInt(in.nextLine());
		} catch (NumberFormatException exc) {

			System.out.println("Dammi un numero intero!");
		}
		
		System.out.println("Il riusltato è: " + (x + y));
	}
}
