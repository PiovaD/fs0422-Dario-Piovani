package esercitazionew3d3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import models.Concerto;
import models.Evento;
import models.Gender;
import models.GenereConcerto;
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

//		Location loc1 = saveLocation("Palazzo Pirelli", "Milano");
//		Evento ev1 = saveEvento("Hackathon", "Finale", LocalDate.now(), 10, loc1, TipoEvento.PUBBLICO);
//		Persona per1 = savePersona("Mario", "Rossi", "m.rossi@google.com", LocalDate.of(1991, 4, 23), Gender.MASCHIO);
//
//		savePartecipazione(ev1, per1, Stato.CONFERMATA);
//		
//		Location loc2 = saveLocation("Teatro Regio", "Padova");
//		Evento ev2 = saveEventoConcerto("Estasi Tour", "Giovanni Allevi", LocalDate.of(2022, 12, 20), 300, loc2, TipoEvento.PUBBLICO, GenereConcerto.CLASSICO, false);
//
//		savePartecipazione(ev2, per1, Stato.DA_CONFERMARE);
//		
//		Location loc3 = saveLocation("Wembley Stadium", "Wembley");
//		Evento ev3 = saveEventoConcerto("Tour 2022", "Queen", LocalDate.of(1986,7,12), 10000, loc3, TipoEvento.PRIVATO, GenereConcerto.ROCK, true);
//		Persona per2 = savePersona("Wario", "Grossi", "w.grossi@google.com", LocalDate.of(1968, 8, 24), Gender.MASCHIO);
//
//		savePartecipazione(ev3, per2, Stato.CONFERMATA);

		List<Concerto> st = EventoDAO.getConcertiInStreaming(true);

		List<Concerto> cg = EventoDAO.getConcertiPerGenere(GenereConcerto.CLASSICO);

		List<Object[]> partecipanti = PartecipazioneDAO.getPartecipantiId(1L);

		printConcerto(st);

		System.out.println(LogColor.YELLOW("------------------------------------------------------------------"));

		printConcerto(cg);

		System.out.println(LogColor.YELLOW("------------------------------------------------------------------"));

		
		for (int i = 0; i < partecipanti.size(); i++) {
			
			Object[] o = partecipanti.get(i);	
			
			System.out.println(LogColor.GREEN(Arrays.toString(o)));
		}

	}

	static void printConcerto(List<Concerto> listObj) {

		for (Concerto c : listObj) {
			System.out.println(LogColor.CYAN(c.toString()));
		}
	}

	static Partecipazione savePartecipazione(Evento evento, Persona persona, Stato partecipazione) {
		Partecipazione part = new Partecipazione(persona, evento, partecipazione);

		PartecipazioneDAO.save(part);

		return part;
	}

	static Persona savePersona(String name, String lastName, String email, LocalDate birth, Gender g) {
		Persona per = new Persona(name, lastName, email, birth, g);

		PersonaDAO.save(per);
		return per;
	}

	static Location saveLocation(String nome, String citta) {
		Location loc = new Location(nome, citta);
		LocationDAO.save(loc);
		return loc;
	}

	static Evento saveEvento(String name, String desc, LocalDate date, int maxPeople, Location loc, TipoEvento tipo) {
		Evento ev = new Evento(name, date, desc, tipo, maxPeople, loc);
		EventoDAO.save(ev);
		return ev;
	}

	static Evento saveEventoConcerto(String name, String desc, LocalDate date, int maxPeople, Location loc,
			TipoEvento tipo, GenereConcerto gc, boolean isStreaming) {
		Concerto ev = new Concerto(name, date, desc, tipo, maxPeople, loc, gc, isStreaming);
		EventoDAO.save(ev);
		return ev;
	}

}
