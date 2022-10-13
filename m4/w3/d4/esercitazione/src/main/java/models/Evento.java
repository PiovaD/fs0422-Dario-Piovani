package models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "event")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "event_type", discriminatorType = DiscriminatorType.STRING)
//@NamedQuery(name="eventiSoldOut", query="SELECT e FROM Evento e WHERE e.numeroMassimoPartecipanti = SIZE(e.partecipazioni)")
//@NamedQuery(name="eventiPerInvitato", query="SELECT e FROM Evento AS e WHERE EXISTS(SELECT p FROM e.partecipazioni p WHERE p.persona = :invitato)")
public class Evento {

	@Id
	@SequenceGenerator(name = "IdEvento_seq", sequenceName = "IdEvento_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "IdEvento_seq")
	private long id;
	
	private String titolo;
	
	private LocalDate dataEvento;
	
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	
	private int numeroMassimoPartecipanti;
	
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private Set<Partecipazione> partecipazioni = new HashSet<Partecipazione>();
	
	@ManyToOne
	@JoinColumn(name = "id_location")
	private Location location;
	
	public Evento() {
	}
	
	public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.location = location;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public long getId() {
		return id;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti
				+ ", location=" + location + "]";
	}

	
	
	
}
