package gestionePrenotazioni.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// L'edificio ha un nome, un indirizzo ed una città.

@Getter
@Setter
@ToString
@Entity
@Table(name = "buildings")
public class Building {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String address;
	private String city;
	
	@OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
	private Set<Workstation> workstationSet = new HashSet<Workstation>();
	
	public Building() {
	}

	public Building(String name, String address, String city) {
		this.name = name;
		this.address = address;
		this.city = city;
	}
	
}
