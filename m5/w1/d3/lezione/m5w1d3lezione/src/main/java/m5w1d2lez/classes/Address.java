package m5w1d2lez.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
	private String road;

	@Override
	public String toString() {
		return "Address [road=" + road + "]";
	}
	
}
