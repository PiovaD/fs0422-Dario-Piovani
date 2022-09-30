package playerMultimediale;

import java.util.Scanner;

import playerMultimediale.multimedia.Audio;
import playerMultimediale.multimedia.ElementoMultimediale;
import playerMultimediale.multimedia.Immagine;
import playerMultimediale.multimedia.Video;

public class PlayerMultimediale {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		ElementoMultimediale[] lettore = new ElementoMultimediale[5];

		for (int i = 0; i < lettore.length; i++) {
			lettore[i] = inserimento(i, in);
		}

		printListaMultimedia(lettore);

		whatsNext(lettore, in);

		System.out.println("the end");
		in.close();
	}

	static void printListaMultimedia(ElementoMultimediale[] arr) {
		System.out.println("--- i tuoi elementi ---");
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + ": " + arr[i].getTitle());
		}
		System.out.println("-----------------------");
	}

	static ElementoMultimediale inserimento(int i, Scanner in) {
		String userIns;

		while (true) {
			System.out.printf("Inserisci il tipo (audio, video, immagine) del %s° elemento: ", i + 1);
			userIns = in.nextLine().toUpperCase();

			switch (userIns) {

			case "VIDEO":
				return creaVideo(in);

			case "AUDIO":
				return creaAudio(in);

			case "IMMAGINE":
				return creaImmagine(in);
			}

			System.out.println("Errore nella selezione del tipo");
		}

	}

	static void whatsNext(ElementoMultimediale[] arr, Scanner in) {
		int then;
		do {

			System.out.println("Quale oggetto vuoi eseguire(inserisci numero da 1 a 5 oppure 0 per finire)");
			then = Integer.parseInt(in.nextLine());

			if (then > 0 && then <= 5) {
		
				arr[then - 1].esegui();
			}

		} while (then != 0);
	}

	static Immagine creaImmagine(Scanner in) {
		return new Immagine(title(in), brightness(in));
	}

	static Audio creaAudio(Scanner in) {
		return new Audio(title(in), duration(in), volume(in));
	}

	static Video creaVideo(Scanner in) {
		return new Video(title(in), duration(in), volume(in), brightness(in));

	}

	private static String title(Scanner in) {
		System.out.printf("Inserisci il titolo: ");
		String title;
		do {

			title = in.nextLine();

		} while (title.length() == 0);

		return title;
	}

	private static int duration(Scanner in) {
		System.out.printf("Inserisci la durata > di 0: ");
		return intVal(in);
	}

	private static int brightness(Scanner in) {
		System.out.printf("Inserisci la luminosità > di 0: ");
		return intVal(in);
	}

	private static int volume(Scanner in) {
		System.out.printf("Inserisci il volume > di 0: ");
		return intVal(in);
	}

	private static int intVal(Scanner in) {
				
		int val = Integer.parseInt(in.nextLine());
		
		while (val <= 0) {
			System.out.println("Valore inserito errato, riprova (deve essere maggiore di 0)");
			val = Integer.parseInt(in.nextLine());
		}
		return val;
	}

}
