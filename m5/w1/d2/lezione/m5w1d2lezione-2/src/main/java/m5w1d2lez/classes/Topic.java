package m5w1d2lez.classes;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class Topic {
	
	private static int IdCount=0;
	
	private int id;
	private String name;
	
	public Topic() {
		id = IdCount++;
	}
	
	public Topic(String name) {
		id = IdCount++;
		this.name = name;
	}

}
