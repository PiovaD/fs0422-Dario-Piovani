package m5w1d2lez.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Box {
	
	private int  x, y;

	public int area() {
		return x*y;
	}

}
