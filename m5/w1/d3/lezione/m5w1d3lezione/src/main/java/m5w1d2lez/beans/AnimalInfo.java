package m5w1d2lez.beans;

//import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalInfo {

	//@Value("${dog2.breed}")
	private String breed;
	
	//@Value("${dog2.price}")
	private double price;

	@Override
	public String toString() {
		return "AnimalInfo [breed=" + breed + ", price=" + price + "]";
	}

}
