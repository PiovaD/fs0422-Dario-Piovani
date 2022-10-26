package m5w1d2lez.beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class DogTest {

	@Test
	public void test() {
		Dog d1 = new Dog();
		
		AnimalInfo ai= new AnimalInfo("Doggo", 50);
		
		d1.setAnimalInfo(ai);
		
		assertTrue("Il prezzo è maggiore di 100", d1.getAnimalInfo().getPrice() > 50);		
		
	}

}
