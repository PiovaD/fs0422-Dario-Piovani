package m5w1d2lez.components;

import org.springframework.stereotype.Component;

@Component
public class MathTeacher extends Teacher{
	
	@Override
	public void hello() {
		System.out.println("Sono un Math teacher");		
	}

	@Override
	public String toString() {
		return "MathTeacher [Name=" + getName() + "]";
	}	
	
}
