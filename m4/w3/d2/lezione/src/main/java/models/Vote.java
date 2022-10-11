package models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private int vote;
	
	// abbiamo una persona refernziata dalla foreign key chiamata p_id
	@ManyToOne
	@JoinColumn(name="p_id")
	private Person5 person;
	
	
	public Vote() {};

	public Vote(int vote, Person5 person) {
		super();
		this.vote = vote;
		this.person = person;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public Person5 getPerson() {
		return person;
	}

	public void setPerson(Person5 person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return this.vote + "";
	}
	
}
