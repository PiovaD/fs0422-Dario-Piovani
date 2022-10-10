package esercitazionew3d1;

import java.time.LocalDate;

import models.Evento;
import models.EventoDAO;
import models.TipoEvento;

public class Main {
	
public static void main(String[] args) {
		
		Evento evento1 = new Evento("Hackathon", LocalDate.now(), "Finale", TipoEvento.PUBBLICO, 10);
		Evento evento2 = new Evento("Ev 1", LocalDate.now(), "D 1", TipoEvento.PRIVATO, 15);
		Evento evento3 = new Evento("Ev 2", LocalDate.now(), "D 2", TipoEvento.PUBBLICO, 5);
		
		EventoDAO.save(evento1);
		EventoDAO.save(evento2);
		EventoDAO.save(evento3);

		System.out.println(EventoDAO.getById(1L));
		
		//EventoDAO.refresh(evento1);
		
		EventoDAO.delete(1L);
	}

}



