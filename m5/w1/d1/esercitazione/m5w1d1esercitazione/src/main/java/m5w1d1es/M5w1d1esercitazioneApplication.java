package m5w1d1es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import m5w1d1es.utils.LogColor;

@SpringBootApplication
public class M5w1d1esercitazioneApplication {

	public static void main(String[] args) {
		SpringApplication.run(M5w1d1esercitazioneApplication.class, args);
		
		System.out.println("Hello world");
		
		GestioneMenu stampa = new GestioneMenu();
		stampa.stampaMenu();
		
		LogColor.infoMessage("Seconda Parte");
		
		stampa.testTopping();
	}

}
