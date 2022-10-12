package models.s1;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MyCat")
public class S1_Cat extends S1_Animal{
	
	@Column(name = "jump_heigth")
	private int jumpHeigth;

	public S1_Cat() {
	}

	public S1_Cat(String name, int age, int jumpHeigth) {
		super(name, age);
		this.jumpHeigth=jumpHeigth;
	}

	public int getJumpHeigth() {
		return jumpHeigth;
	}

	public void setJumpHeigth(int jumpHeigth) {
		this.jumpHeigth = jumpHeigth;
	}
	
	
	
}
