package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person5")
public class Person5 {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	// la persona ha un indirizzo, significa che ha una colonna address_id che refernzia un id in Address
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="address_id", referencedColumnName = "id")
	private Address address;
	
	// la persona ha più voti, ogni voto è una row di Vote
	@OneToMany(mappedBy = "person")
	private Set<Vote> votes;
	
	// hai una tabella esterna che contiene la pk di questa tabella (principale) e la pk di post (secondaria)
	@ManyToMany()
	@JoinTable(
		      name = "person5_post", 
		      joinColumns = @JoinColumn(name = "person5_id"), 
		      inverseJoinColumns = @JoinColumn(name = "post_id"))
	private Set<Post> posts;

	
	

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Person5(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
	public Set<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person5() {};
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}