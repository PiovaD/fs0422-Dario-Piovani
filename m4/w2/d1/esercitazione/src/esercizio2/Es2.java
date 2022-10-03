package esercizio2;

import java.util.Scanner;

public class Es2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.printf("Inserisci i Km percorsi: ");

		try {
			double km = Integer.parseInt(in.nextLine());

			if (km < 0) {
				in.close();
				throw new IllegalArgumentException();
			}
			
			System.out.printf("Inserisci i litri consumati: ");

			double litri = Integer.parseInt(in.nextLine());
			
			if (litri < 0) {
				in.close();
				throw new IllegalArgumentException();
			}

			kilometriAlLitro(km, litri);

			in.close();

		} catch (NumberFormatException exc) {
			System.out.println("Input inserito errato");
		} catch (IllegalArgumentException exc) {
			System.out.println("Solo numeri positivi");
		}

		finally {
			System.out.println("THE END");
		}

	}

	public static void kilometriAlLitro(double km, double litri) {

		try {

			if (litri == 0)
				throw new ArithmeticException("Stai dividendo per 0");

			System.out.println("Il tuo consumo è di: " + km / litri + 'l');

		} catch (ArithmeticException exc) {

			System.out.println(exc.getLocalizedMessage());
		}
	}
}
