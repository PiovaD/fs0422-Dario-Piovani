package models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String text;
	
	// tabella esterna con info dichiarata nell'entità che mappa la tabella principale
	@ManyToMany(mappedBy = "posts" )
	private Set<Person5> people;
	
	
	public Set<Person5> getPeople() {
		return people;
	}

	public void setPeople(Set<Person5> people) {
		this.people = people;
	}

	public Post(String text) {
		this.text = text;
	}
	
	public Post() {};

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
