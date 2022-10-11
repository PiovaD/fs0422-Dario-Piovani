package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "person4")
public class Person4 {
	
	@Id
	@SequenceGenerator(
			name="person4_seq",
		sequenceName = "person4_seq",
		initialValue = 2,
		allocationSize = 1
		)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person4_seq")
	private int id;
	
	private String name;
	
	public Person4() {
	}

	public Person4(String name) {
		this.name = name;
	}

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