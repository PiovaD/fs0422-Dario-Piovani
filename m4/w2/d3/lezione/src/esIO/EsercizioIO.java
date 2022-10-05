package esIO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class EsercizioIO {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String fileName = "doc/es1.txt";
		File file1 = new File(fileName);

		String encoding = "UTF-8";
		
		try {
			FileUtils.writeStringToFile(file1, "" , encoding);
		} catch (IOException e1) {
			System.out.println("file errato");
		}

		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Inserisci numero");
				int num = Integer.parseInt(scanner.nextLine());

				FileUtils.writeStringToFile(file1, num + ((i < 4) ? "-" : ""), encoding, true);

			} catch (NumberFormatException e) {
				System.out.println("val errato");
				i--;
			} catch (IOException e) {
				System.out.println("file errato");
				break;
			}

		}
		
		FileText.leggi(fileName);

		scanner.close();
	}
}

class FileText {

	static void leggi(String path) {
		File file1 = new File(path);
		String encoding = "UTF-8";

		if (file1.exists()) {
			try {
				String contenuto = FileUtils.readFileToString(file1, encoding);

				if (contenuto.length() > 0) {
					System.out.println("Il contenuto è: " + java.util.Arrays.toString(contenuto.split("-")));
				}

			} catch (IOException e) {
				System.out.println("file errato");

			}
		}
	}
}