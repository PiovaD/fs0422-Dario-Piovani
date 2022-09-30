package playerMultimediale;

import java.util.Scanner;

public class PlayerMultimediale {

	public static void main(String[] args) {

		ElementoMultimediale[] lettore = new ElementoMultimediale[5];

		for (int i = 0; i < lettore.length; i++) {

			//MultimediaType multType = selezioneTipo(i);

			//lettore[i] = inserimento(multType);

		}

		System.out.println("the end");

	}

	public static void selezioneTipo(int i) {
		Scanner in = new Scanner(System.in);
		String userIns;
		
		while (true) {
			System.out.printf("Inserisci il tipo (audio, video, immagine) del %s° elemento: ", i + 1);
			userIns = in.nextLine().toUpperCase();
			switch (userIns) {
			
			case "VIDEO":				
				break;
				
			case "AUDIO":				
				break;
				
			case "IMMAGINE":
				break;
			}
			
			System.out.println("Errore nella selezione del tipo");
		}

	}



}
