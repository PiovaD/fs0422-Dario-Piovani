package esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Es1 {

	public static void main(String[] args) {

		Thread t1 = new Th("*");
		Thread t2 = new Th("#");

		t1.start();
		t2.start();

	}
}

class Th extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(Th.class);

	Th(String name) {
		this.setName(name);
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				logger.info(Thread.currentThread().getName() + " n° " + (i + 1));

				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			logger.error("Errore sleep");
		}
	}
}
