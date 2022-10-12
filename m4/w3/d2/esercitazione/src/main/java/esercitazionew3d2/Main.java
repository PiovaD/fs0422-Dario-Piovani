package esercitazionew3d2;

import java.time.LocalDate;

import models.Evento;
import models.Gender;
import models.Location;
import models.Partecipazione;
import models.Persona;
import models.Stato;
import models.TipoEvento;
import models.dao.EventoDAO;
import models.dao.LocationDAO;
import models.dao.PartecipazioneDAO;
import models.dao.PersonaDAO;
import utils.LogColor;

public class Main {

	public static void main(String[] args) {

		Location loc = saveLocation();
		Evento ev = saveEvento(loc, TipoEvento.PUBBLICO);
		Persona per = savePersona();

		Partecipazione par = savePartecipazione(ev, per, Stato.CONFERMATA);

		System.out.println(LogColor.GREEN(loc.toString()));
		
		System.out.println(LogColor.GREEN(ev.toString()));
		
		System.out.println(LogColor.GREEN(per.toString()));
		
		System.out.println(LogColor.GREEN(par.toString()));
		
//		Evento ev2 = EventoDAO.getById(1L);
//		System.out.println(LogColor.GREEN(ev2.toString()));
		

	}

	private static Partecipazione savePartecipazione(Evento evento, Persona persona, Stato partecipazione) {
		Partecipazione part = new Partecipazione(persona, evento, partecipazione);

		PartecipazioneDAO.save(part);

		return part;
	}

	private static Persona savePersona() {
		Persona per = new Persona("Mario", "Rossi", "m.rossi@google.com", LocalDate.of(1991, 4, 23), Gender.MASCHIO);

		PersonaDAO.save(per);
		return per;
	}

	private static Location saveLocation() {
		Location loc = new Location("Palazzo Pirelli", "Milano");
		LocationDAO.save(loc);
		return loc;
	}

	private static Evento saveEvento(Location loc, TipoEvento tipo) {
		Evento ev = new Evento("Hackathon", LocalDate.now(), "Finale", tipo, 10, loc);
		EventoDAO.save(ev);
		return ev;
	}

}
