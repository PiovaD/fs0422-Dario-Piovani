package esercitazionew3d4;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import models.Concerto;
import models.Evento;
import models.GaraDiAtletica;
import models.Gender;
import models.GenereConcerto;
import models.Location;
import models.Partecipazione;
import models.PartitaDiCalcio;
import models.Persona;
import models.Stato;
import models.TipoEvento;
import models.dao.EventoDAO;
import models.dao.LocationDAO;
import models.dao.PartecipazioneDAO;
import models.dao.PersonaDAO;

public class Main {
	
	/*Esercizio #1
PartecipazioneDAO;
- getPartecipazioniDaConfermarePerEvento(Evento evento)*/

	public static void main(String[] args) {
		
//		Location loc1 = saveLocation("SanSiro", "Milano");
//		saveEventoPartita("Coppa Italia", "Finale", LocalDate.now(), 1000, loc1, TipoEvento.PUBBLICO,"Milan", "Inter", 3, 2);
//		
//		Location loc2 = saveLocation("Olimpico", "Roma");
//		saveEventoPartita("Seria a", "4a Giornata", LocalDate.now(), 10, loc2, TipoEvento.PUBBLICO,"Roma", "Lazio", 0, 0);

		EventoDAO.getPartiteVinteInCasa("Milan");
		EventoDAO.getPartiteVinteInCasa("Inter");
		
		EventoDAO.getPartitePareggiate("Milan");
		EventoDAO.getPartitePareggiate("Roma");
		
//		Set<Persona> sa1 = new HashSet<Persona>();	
//		
//		sa1.add(PersonaDAO.getById(1L));
//		sa1.add(PersonaDAO.getById(2L));
//		sa1.add(PersonaDAO.getById(3L));
//	
//		saveEventoGaraAtletica("100m", "Finale", LocalDate.now(), 1000, LocationDAO.getById(3L), TipoEvento.PUBBLICO, PersonaDAO.getById(1L),sa1);
//		
//		Set<Persona> sa2 = new HashSet<Persona>();
//		
//		sa2.add(PersonaDAO.getById(1L));
//		sa2.add(PersonaDAO.getById(2L));
//		sa2.add(PersonaDAO.getById(3L));
//		sa2.add(PersonaDAO.getById(4L));
//		sa2.add(PersonaDAO.getById(5L));
//				
//		saveEventoGaraAtletica("staffetta", "qual. olimpica", LocalDate.now(), 1_000, LocationDAO.getById(2L), TipoEvento.PRIVATO, PersonaDAO.getById(1L),sa2);
		
		EventoDAO.getGareDiAtleticaPerVincitore(PersonaDAO.getById(1L));
		
		EventoDAO.getGareDiAtleticaPerPartecipante(PersonaDAO.getById(1L));
		EventoDAO.getGareDiAtleticaPerPartecipante(PersonaDAO.getById(4L));
		
		EventoDAO.getEventiSoldOut();
		//EventoDAO.getEventiPerInvitato(PersonaDAO.getById(1L));
		
		//PartecipazioneDAO.getPartecipazioniDaConfermarePerEvento(EventoDAO.getById(1L));
		
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
	
	static Evento saveEventoPartita(String name, String desc, LocalDate date, int maxPeople, Location loc,
			TipoEvento tipo, String squadraCasa, String squadraOspite, int golCasa,
			int golOspite) {
		PartitaDiCalcio ev = new PartitaDiCalcio(name, date, desc, tipo, maxPeople, loc, squadraCasa,squadraOspite,golCasa,golOspite);
		EventoDAO.save(ev);
		return ev;
	}
	
	static Evento saveEventoGaraAtletica(String titolo, String descrizione, LocalDate dataEvento,
			int numeroMassimoPartecipanti, Location location, TipoEvento tipoEvento,
			  Persona winner, Set<Persona> setAtleti) {
		GaraDiAtletica ev = new GaraDiAtletica( titolo,  dataEvento,  descrizione,  tipoEvento,
				 numeroMassimoPartecipanti,  location,  winner);
		
		ev.setSetAtleti(setAtleti);
		EventoDAO.save(ev);
		return ev;
	}


}
