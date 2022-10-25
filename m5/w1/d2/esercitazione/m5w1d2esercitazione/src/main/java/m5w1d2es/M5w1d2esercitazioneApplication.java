package m5w1d2es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class M5w1d2esercitazioneApplication {

	public static void main(String[] args) {
		SpringApplication.run(M5w1d2esercitazioneApplication.class, args);
		
		GestioneMenu stampa = new GestioneMenu();
		stampa.stampaMenu();
		
	}

}
