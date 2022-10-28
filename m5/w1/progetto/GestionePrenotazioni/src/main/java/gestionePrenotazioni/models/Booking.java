package gestionePrenotazioni.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
La prenotazione vale per un solo giorno e può essere effettuata solo se per quel giorno la postazione
risulta libera. Un utente può ricercare le postazioni indicando il tipo di postazione desiderato e la città di interesse.
Un utente può avere più prenotazioni in corso, ma non può prenotare più di una postazione per una particolare
data. 
*/

@Getter
@Setter
@ToString
@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDate validity;
	
	@ManyToOne
	private Workstation workstation;	
	
	@ManyToOne
	private User user;
	
	public Booking() {
	}

	public Booking(LocalDate validity, Workstation workstation, User user) {
		this.validity = validity;
		this.workstation = workstation;
		this.user = user;
	}
	
	
}
