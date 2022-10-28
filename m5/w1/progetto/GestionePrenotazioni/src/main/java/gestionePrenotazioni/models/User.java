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

//utente, che è identificato da uno username, un nome completo ed una email.

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String username;
	
	private String name;
	private String email;
	
	@OneToMany(mappedBy = "user")
	private Set<Booking> bookings = new HashSet<Booking>();
	
	public User() {
	}

	public User(String username, String name, String email) {
		this.username = username;
		this.name = name;
		this.email = email;
	}
	
}
