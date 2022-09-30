package playerMultimediale;

import java.util.Scanner;

import playerMultimediale.multimedia.Audio;
import playerMultimediale.multimedia.ElementoMultimediale;
import playerMultimediale.multimedia.Immagine;
import playerMultimediale.multimedia.Video;

public class PlayerMultimediale {

	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ElementoMultimediale[] lettore = new ElementoMultimediale[5];

		for (int i = 0; i < lettore.length; i++) {
			lettore[i] = inserimento(i);
		}

		printListaMultimedia(lettore);

		whatsNext(lettore);

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

	static ElementoMultimediale inserimento(int i) {
		String userIns;

		while (true) {
			System.out.printf("Inserisci il tipo (audio, video, immagine) del %s° elemento: ", i + 1);
			userIns = in.nextLine().toUpperCase();

			switch (userIns) {

			case "VIDEO":
				return creaVideo();

			case "AUDIO":
				return creaAudio();

			case "IMMAGINE":
				return creaImmagine();
			}

			System.out.println("Errore nella selezione del tipo");
		}

	}

	static void whatsNext(ElementoMultimediale[] arr) {
		int then;
		do {

			System.out.println("Quale oggetto vuoi eseguire(inserisci numero da 1 a 5 oppure 0 per finire)");
			then = Integer.parseInt(in.nextLine());

			if (then > 0 && then <= 5) {
		
				arr[then - 1].esegui();
			}

		} while (then != 0);
	}

	static Immagine creaImmagine() {
		return new Immagine(title(), brightness());
	}

	static Audio creaAudio() {
		return new Audio(title(), duration(), volume());
	}

	static Video creaVideo() {
		return new Video(title(), duration(), volume(), brightness());

	}

	private static String title() {
		System.out.printf("Inserisci il titolo: ");
		String title;
		do {

			title = in.nextLine();

		} while (title.length() == 0);

		return title;
	}

	private static int duration() {
		System.out.printf("Inserisci la durata > di 0: ");
		return intVal();
	}

	private static int brightness() {
		System.out.printf("Inserisci la luminosità > di 0: ");
		return intVal();
	}

	private static int volume() {
		System.out.printf("Inserisci il volume > di 0: ");
		return intVal();
	}

	private static int intVal() {
				
		int val = Integer.parseInt(in.nextLine());
		
		while (val <= 0) {
			System.out.println("Valore inserito errato, riprova (deve essere maggiore di 0)");
			val = Integer.parseInt(in.nextLine());
		}
		return val;
	}

}
