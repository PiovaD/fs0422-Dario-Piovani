package m5w1d2lez.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sc")
public class School {

	private String name;
	
	@Autowired
	@Qualifier("mathTeacher")
	private Teacher Teacher;

	@Override
	public String toString() {
		return "School [name=" + name + ", teacher=" + Teacher + "]";
	}
}
