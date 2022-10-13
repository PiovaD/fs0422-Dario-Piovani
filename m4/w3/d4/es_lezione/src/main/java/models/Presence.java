package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "presence")
public class Presence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int numPresenze;
	
	@OneToOne(mappedBy = "presenza")
	private Student student;
	
	public Presence() {
	}

	public Presence(int numPresenze, Student student) {
		this.numPresenze = numPresenze;
		this.student = student;
	}

	public int getNumPresenze() {
		return numPresenze;
	}

	public void setNumPresenze(int numPresenze) {
		this.numPresenze = numPresenze;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}
	
	
}
