package m5w1d2lez.classes;

import java.util.List;

public class ReactStudent extends AbStudent{

	public ReactStudent(String name, Gender gender, List<Topic> topics, Address address,  double avg) {
		super(name, gender, topics, address, avg);
	}
	
	public ReactStudent() {
		super();
	}

	@Override
	public void hello() {
		System.out.println("Sono uno studente di react");		
	}

}
