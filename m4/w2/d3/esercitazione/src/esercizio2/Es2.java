package esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Es2 {

	public static void main(String[] args) {

		ArrayList<Integer> intArr = generaArr(3000);

		ThParziale tP1 = new ThParziale("a", intArr.subList(0, ((intArr.size() / 3) - 1)));
		ThParziale tP2 = new ThParziale("b", intArr.subList(intArr.size() / 3, (((intArr.size() / 3) * 2) - 1)));
		ThParziale tP3 = new ThParziale("c", intArr.subList(((intArr.size() / 3) * 2), 3000 - 1));

		tP1.start();
		tP2.start();
		tP3.start();

		try {
			tP1.join();
			tP2.join();
			tP3.join();

			ThParziale.logger.info("La somma è : " + (tP1.getSomma() + tP2.getSomma() + tP3.getSomma()));
		} catch (InterruptedException e) {
			System.err.println("errore: " + e.getLocalizedMessage());
		}

	}

	static ArrayList<Integer> generaArr(int size) {
		ArrayList<Integer> intArr = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			intArr.add(new Random().nextInt(10));
		}
		return intArr;
	}
}

class ThParziale extends Thread {

	static final Logger logger = LoggerFactory.getLogger(ThParziale.class);

	private List<Integer> intArr;
	private int somma = 0;

	public ThParziale(String name, List<Integer> intArr) {
		this.setName(name);
		this.intArr = intArr;
	}

	@Override
	public void run() {
		somma();
		logger.info("Th: " + this.getName() + " Somma: " + getSomma());
	}

	private void somma() {
		for (int i : intArr) {
			this.somma += i;
		}
	}

	public int getSomma() {
		return somma;
	}

}