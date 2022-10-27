package m5w1d4lez3.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String model;
	private double price;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "engine_id")
	private Engine engine;
	
	@OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	public Car(String model, double price, Engine engine, Owner owner) {
		this.model = model;
		this.price = price;
		this.engine = engine;
		this.owner = owner;
	}	
	
}
