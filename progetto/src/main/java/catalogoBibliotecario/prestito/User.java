package catalogoBibliotecario.prestito;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

/*
 L'utente è caratterizzato dai seguenti attributi:
- Nome
- Cognome
- Data di nascita
- Numero di tessera
*/

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String lastName;
	private LocalDate birthDate;	
	
	@Column(unique = true)
	private String libraryCardId;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Loan> loanSet = new HashSet<Loan>();
	
	public User() {}

	public User(String name, String lastName, LocalDate birthDate, String libraryCardId) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.libraryCardId = libraryCardId;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

	public String getLibraryCardId() {
		return libraryCardId;
	}
	
	

	public Set<Loan> getLoanSet() {
		return loanSet;
	}

	public void setLoanSet(Set<Loan> loanSet) {
		this.loanSet = loanSet;
	}

	@Override
	public String toString() {
		return "User [id=" + this.id + ", name=" + this.name + ", lastName=" + this.lastName + ", birthDate=" + this.birthDate
				+ ", libraryCardId=" + this.libraryCardId + "]";
	}
}
