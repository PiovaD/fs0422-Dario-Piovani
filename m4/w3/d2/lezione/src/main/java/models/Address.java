package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String street;
	private String city;
	
	@OneToOne(mappedBy = "address")
	@JoinColumn(name = "person5_id")
	private Person5 person;
	
	public Person5 getPerson() {
		return person;
	}

	public void setPerson(Person5 person) {
		this.person = person;
	}

	public Address() {};
	
	public Address(String road, String city) {
		super();
		this.street = road;
		this.city = city;
	}
	public String getRoad() {
		return street;
	}
	public void setRoad(String road) {
		this.street = road;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
