package models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "garePerPartecipante", query = "SELECT g FROM GaraDiAtletica g WHERE :persona MEMBER OF g.setAtleti")
public class GaraDiAtletica extends Evento {

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "athlete",
	joinColumns = @JoinColumn(name = "gara_id"), inverseJoinColumns = @JoinColumn(name="athlete_id"))
	private Set<Persona> setAtleti = new HashSet<Persona>();

	@ManyToOne
	@JoinColumn(name = "id_person")
	private Persona winner;

	public GaraDiAtletica() {
	}

	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, Persona winner) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		
		this.winner = winner;
		
	}

	public Persona getVincitore() {
		return winner;
	}

	public void setVincitore(Persona winner) {
		this.winner = winner;
	}

	public Set<Persona> getSetAtleti() {
		return setAtleti;
	}

	public void setSetAtleti(Set<Persona> setAtleti) {
		this.setAtleti = setAtleti;
	}
	
	

}
