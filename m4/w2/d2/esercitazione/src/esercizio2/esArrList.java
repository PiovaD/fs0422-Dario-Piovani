package esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class esArrList {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>();

		while (true) {
			System.out.printf("Quanto deve essere grande l'array? ");

			try {
				int elemQuantita = Integer.parseInt(in.nextLine());
				arrList = createArr(elemQuantita);
				break;
			} catch (NumberFormatException exc) {
				System.out.println(exc.getMessage() + " inserisci un intero");
			}
		}

		System.out.println(arrList);

		System.out.println(InverseArr(arrList));

		EvenOrOddArr(arrList, true);
		EvenOrOddArr(arrList, false);

		System.out.println("THE END");
	}

	static ArrayList<Integer> createArr(int size) {

		ArrayList<Integer> arrListTmp = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			int x = new Random().nextInt(101);
			arrListTmp.add(x);
		}

		Collections.sort(arrListTmp);

		return arrListTmp;
	}

	@SuppressWarnings("unchecked")
	static ArrayList<Integer> InverseArr(ArrayList<Integer> arr) {
		ArrayList<Integer> arrListTmp = new ArrayList<>(arr);

		try {
			Collections.sort((ArrayList<Integer>) arr.clone(), Collections.reverseOrder());

			arrListTmp.addAll(arr);
		} catch (Exception exc) {

		}
		return arrListTmp;
	}

	static void EvenOrOddArr(ArrayList<Integer> arr, boolean bool) {

		int printer = bool ? 1 : 0;

		for (int i = printer; i < arr.size(); i += 2) {
			System.out.printf(arr.get(i).toString() + " ");
		}

		System.out.println();

	}
}
