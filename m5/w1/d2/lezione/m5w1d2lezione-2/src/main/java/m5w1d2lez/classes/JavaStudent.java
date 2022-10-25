package m5w1d2lez.classes;

import java.util.List;

public class JavaStudent  extends AbStudent{

	public JavaStudent(String name, Gender gender, List<Topic> topics,Address address,  double avg) {
		super(name, gender, topics, address, avg);
	}

	public JavaStudent() {
		super();
	}

	@Override
	public void hello() {
		System.out.println("Sono uno studente di Java");			
	}

}
