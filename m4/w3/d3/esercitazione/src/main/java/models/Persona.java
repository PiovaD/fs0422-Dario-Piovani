package models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Persona {

	@Id
	@SequenceGenerator(name = "persona_seq", sequenceName = "persona_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "persona_seq")
	private long id;
	private String name;
	private String lastName;
	private String email;
	private LocalDate birthDate;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	@OrderBy(value = "evento.dataEvento")
	private List<Partecipazione> ListaPartecipazioni;
	
	public Persona() {
	}

	public Persona(String name, String lastName, String email, LocalDate birthDate, Gender gender) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.birthDate = birthDate;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Partecipazione> getListaPartecipazioni() {
		return ListaPartecipazioni;
	}

	public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
		ListaPartecipazioni = listaPartecipazioni;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", birthDate="
				+ birthDate + ", gender=" + gender + "]";
	}
	
	
}
