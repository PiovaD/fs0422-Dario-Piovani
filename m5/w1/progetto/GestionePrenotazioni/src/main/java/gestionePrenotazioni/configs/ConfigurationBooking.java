package gestionePrenotazioni.configs;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import gestionePrenotazioni.models.Booking;
import gestionePrenotazioni.models.Building;
import gestionePrenotazioni.models.User;
import gestionePrenotazioni.models.Workstation;
import gestionePrenotazioni.models.WorkstationType;

@Configuration
public class ConfigurationBooking {

	@Bean(name = "b1")
	@Scope("singleton")
	public Building newBuilding1() {
		return new Building("Epicode", "Via dei Magazzini Generali, 16", "Roma");
	}
	
	@Bean(name = "ws1")
	@Scope("prototype")
	public Workstation newWorkstation1() {
		Workstation w = new Workstation("Cubicolo", WorkstationType.PRIVATE, 1);
		w.setBuilding(newBuilding1());
		return w;
	}
	
	@Bean(name = "ws2")
	@Scope("prototype")
	public Workstation newWorkstation2() {
		return new Workstation("La grande vetrata (Serra)", WorkstationType.MEETING_ROOM, 50);
	}

	@Bean(name = "u1")
	@Scope("singleton")
	public User newUser1() {
		return new User("user1", "Dante", "dante@gmail.com");
	}

	@Bean
	@Scope("singleton")
	public Booking newBooking1() {
		return new Booking(LocalDate.now(), newWorkstation1(), newUser1());
	}
	
	@Bean
	@Scope("singleton")
	public Booking newBooking2() {
		return new Booking(LocalDate.now(), newWorkstation2(), newUser1());
	}
}
