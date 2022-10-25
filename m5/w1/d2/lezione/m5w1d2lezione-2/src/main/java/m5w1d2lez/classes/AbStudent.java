package m5w1d2lez.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class AbStudent implements IStudent{
	private static int IdCount=0;
	
	private int id;
	private String name;
	private Gender gender;
	
	//@Autowired
	private List<Topic> topics;
	
	@Autowired
	private Address address;
	private double avg;
	
	public AbStudent(String name, Gender gender, List<Topic> topics,Address address, double avg) {
		this.id = IdCount++;
		this.name = name;
		this.gender = gender;
		this.topics = topics ;
		this.address = address;
		this.avg = avg;
	}
	
	public AbStudent() {
	}

	@Override
	public void addTopic(Topic t) {
		topics.add(t);
	}

}
