package esercizio1;

import java.util.Scanner;

public class Es1 {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = randomArr(5);

		printArr(arr);

		while (cambiaElemento(arr)) {
			printArr(arr);
		}

		in.close();
		System.out.println("THE END");
	}

	public static int[] randomArr(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1;
		}

		return arr;
	}

	public static void printArr(int arr[]) {
		for (int elem : arr) {
			System.out.printf(elem + " ");
		}
		System.out.println();
	}

	public static boolean cambiaElemento(int[] arr) {

		int index;
		int val = 0;

		do {
			try {
				System.out.println("In quale posizione vuoi cambiare elemento? 0 per uscire ");
				index = Integer.parseInt(in.nextLine());

				if (index == 0)
					return false;

				System.out.println("Il vecchio valore è: " + arr[index - 1]);

				break;

			} catch (NumberFormatException exc) {
				System.err.println("Dammi un numero intero! compreso da 0 a " + arr.length);

			} catch (ArrayIndexOutOfBoundsException exc) {
				System.err.printf("Errore: " + exc.getMessage() + "%nDammi un numero intero! compreso da 0 a "
						+ arr.length + "%n");
			}

		} while (true);

		do {
			try {
				System.out.printf("Che valore vuoi dare? ");
				val = Integer.parseInt(in.nextLine());

				break;

			} catch (NumberFormatException exc) {

				System.err.println("Dammi un numero intero!");
			}

		} while (true);

		arr[index - 1] = val;

		return true;
	}

}
