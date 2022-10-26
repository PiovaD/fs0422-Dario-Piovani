package m5w1d2lez.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class JavaTeacher extends Teacher{
	
	@Override
	public void hello() {
		System.out.println("Sono un Java teacher");		
	}

	@Override
	public String toString() {
		return "JavaTeacher [Name=" + getName() + "]";
	}
	
}
