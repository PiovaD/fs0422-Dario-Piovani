package gestionePrenotazioni.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Ogni postazione è identificata da un codice univoco, una descrizione,
//un tipo [PRIVATO, OPENSPACE, SALA RIUNIONI], un numero massimo di occupanti ed un edificio.

@Getter
@Setter
@ToString
@Entity
@Table(name = "workstations")
public class Workstation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String description;
	private WorkstationType type;
	private int maxOccupants;
	
	@ManyToOne
	private Building building;

	@OneToMany(mappedBy = "workstation" ,cascade = CascadeType.ALL)
	private Set<Booking> bookings = new HashSet<Booking>();
	
	public Workstation() {
	}

	public Workstation(String description, WorkstationType type, int maxOccupants) {
		this.description = description;
		this.type = type;
		this.maxOccupants = maxOccupants;
	}
	
}
