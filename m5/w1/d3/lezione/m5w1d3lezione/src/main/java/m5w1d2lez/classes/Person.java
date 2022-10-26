package m5w1d2lez.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

	private String name;
	private Address address;

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}

}
