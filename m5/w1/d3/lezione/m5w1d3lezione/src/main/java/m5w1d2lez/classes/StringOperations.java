package m5w1d2lez.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StringOperations {
	
	private String parola;
	
	public int getLength() {
		return parola.length()*2;
	}

}
