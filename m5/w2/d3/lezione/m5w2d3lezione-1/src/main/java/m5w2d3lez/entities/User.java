package m5w2d3lez.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@OneToMany
	private List<Message> messages;
		
	private LocalDate birth;
	private Boolean active = false;
	
	
	public User(String username, LocalDate birth, Boolean active) {
		this.username = username;
		this.birth = birth;
		this.active = active;
	}	
	
}
