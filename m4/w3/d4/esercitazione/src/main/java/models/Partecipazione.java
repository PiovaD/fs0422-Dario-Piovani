package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "partecipation")
public class Partecipazione {
	
	@Id
	@SequenceGenerator(name = "partecipazione_seq", sequenceName = "partecipazione_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "partecipazione_seq")
	private long id;
	

	@ManyToOne
	@JoinColumn(name = "id_person")
	private Persona person;
	
	@ManyToOne
	@JoinColumn(name = "id_event")
	private Evento event;
	
	@Enumerated(EnumType.STRING)
	private Stato state;
	
	public Partecipazione() {
	}

	public Partecipazione(Persona person, Evento event, Stato state) {
		this.person = person;
		this.event = event;
		this.state = state;
	}

	public Persona getPerson() {
		return person;
	}

	public void setPerson(Persona person) {
		this.person = person;
	}

	public Evento getEvent() {
		return event;
	}

	public void setEvent(Evento event) {
		this.event = event;
	}

	public Stato getState() {
		return state;
	}

	public void setState(Stato state) {
		this.state = state;
	}

	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", person=" + person + ", event=" + event + ", state=" + state + "]";
	}
}
