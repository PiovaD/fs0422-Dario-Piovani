package m5w2d4lez.entities;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	private String firstName;
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Calendar birthDate;
	
	private Boolean active;
	
	private String password;
	private String email;
	
	@ManyToMany
	@JoinTable(
			name = "users_roles",	
			joinColumns = @JoinColumn(name = "user_id"),	
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();
	
	
}
