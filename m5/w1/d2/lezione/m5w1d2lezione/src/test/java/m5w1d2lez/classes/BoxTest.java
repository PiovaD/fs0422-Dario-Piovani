package m5w1d2lez.classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoxTest {

	Box b = new Box(5,2,"box");
	
	@Before
	public void beforeAllTest() {
		b.setName("boox");
		b.setX(5);
		b.setY(4);
	}

	@Test
	public void testArea() {		
		System.out.println("Ciao");
		assertEquals("L'area dovrebbe essere 10", b.area(), 20);
	}

	@Test
	public void testName() {		
		assertEquals("Il nome dovrebbe essere box", b.getName(), "boox");
	}
}
