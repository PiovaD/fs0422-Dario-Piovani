package models.s1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MyDog")
public class S1_Dog extends S1_Animal{
	private String owner;

	public S1_Dog() {
	}

	public S1_Dog(String name, int age, String owner) {
		super(name, age);
		this.setOwner(owner);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
	
}
