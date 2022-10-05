package esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;

public class Es3 {

	public static void main(String[] args) {

		RegistroPresenze r1 = new RegistroPresenze("docs/presenze.txt");
		r1.add("Mario rossi", 5);
		r1.add("Giorgio Bianchi", 7);
		r1.add("Gianni Verdi", 7);
		r1.add("Giovanni", 33);
		r1.add("Aldo", 50);
		r1.add("Giacomo", 17);
		
		r1.print();

	}

}

class RegistroPresenze {

	private HashMap<String, Integer> registro = new HashMap<String, Integer>();
	private String encoding = "UTF-8";
	private File registerFolder;

	public RegistroPresenze(String path) {
		this.registerFolder = new File(path);

		if (this.registerFolder.exists() && this.registerFolder.length() > 0) {
			try {
				getByFile();
				System.out.println("File trovato");

			} catch (IOException e) {
				System.err.println("file errato");

			}
		}else {
			System.out.println("File vuoto");
		}
	}

	private void getByFile() throws IOException {

		String[] contentString = FileUtils.readFileToString(this.registerFolder, this.encoding).split("#");

		for (String dipCont : contentString) {
			String[] tmp = dipCont.split("@");
			this.registro.put(tmp[0], Integer.parseInt(tmp[1]));
		}

	}

	public HashMap<String, Integer> getRegistro() {
		return registro;
	}

	public void add(String name, int dayPres) {
		this.registro.put(name, dayPres);
		save();
	}

	public void print() {
		for (Entry<String, Integer> set : this.registro.entrySet()) {

			System.out.println(set.getKey() + " => " + set.getValue());
		}
	}

	public void save() {
		try {
		FileUtils.writeStringToFile(this.registerFolder,"", encoding);

		for (Entry<String, Integer> set : this.registro.entrySet()) {
			
				FileUtils.writeStringToFile(this.registerFolder, set.getKey() + "@" + set.getValue() + "#", encoding,
						true);
			
			}
		} catch (IOException e) {
			System.err.println("Errore nel save");
		}
	}

}
