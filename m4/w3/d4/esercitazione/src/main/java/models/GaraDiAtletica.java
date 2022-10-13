package models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class GaraDiAtletica extends Evento {

	@ManyToMany(targetEntity = Persona.class, cascade = CascadeType.ALL)
	private Set<Persona> setAtleti;

	@ManyToOne
	@JoinColumn(name = "id_person")
	private Persona winner;

	public GaraDiAtletica() {
	}

	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, Set<Persona> setAtleti, Persona winner) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.setAtleti = setAtleti;
		this.winner = winner;
	}

	public Persona getVincitore() {
		return winner;
	}

	public void setVincitore(Persona winner) {
		this.winner = winner;
	}
	
	

}
