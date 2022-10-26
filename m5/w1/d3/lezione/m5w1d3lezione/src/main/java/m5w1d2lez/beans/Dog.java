package m5w1d2lez.beans;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dog {

	private String name;
	
	@Autowired
	private AnimalInfo animalInfo;

	@Override
	public String toString() {
		return "Dog [name=" + name + ", animalInfo=" + animalInfo + "]";
	}
	
}
