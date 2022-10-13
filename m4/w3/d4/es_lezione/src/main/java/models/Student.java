package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {

	@Id
	@SequenceGenerator( name="id_seq", sequenceName="id_seq",initialValue = 3, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	private int id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<Vote> vote;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "presence_id", referencedColumnName = "id")
	private Presence presenza;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_notes",
	joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name="note_id"))
	private Set<BadNote> badNotes;
	
	public Student() {
	}

	public Student(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Set<Vote> getVote() {
		return vote;
	}

	public Presence getPresenza() {
		return presenza;
	}

	public void setPresenza(Presence presenza) {
		this.presenza = presenza;
	}

	public void setVote(Set<Vote> vote) {
		this.vote = vote;
	}

	public int getId() {
		return id;
	}
	
	
}
