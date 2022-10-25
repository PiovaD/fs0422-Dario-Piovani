package m5w1d2lez.classes;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class CalcTest {
	Calc c = new Calc();
	
	@Test
	public void testSum() {
		assertEquals("La somma dovrebbe essere 7",c.sum(5, 2), 7);		
	}
	
	@Test
	//@Ignore
	public void testDif() {
		assertEquals("La differenza dovrebbe essere 3",c.dif(5, 2), 10);		
	}
	
	@Test
	public void test1() {
		String s1 = "ciao";
		String s2 = "ciao";
		assertSame("Senza costruttore dovrebbero essere lo stesso",s1, s2);
	}
	
	@Test
	@Ignore
	public void test2() {
		String s1 = new String("ciao");
		String s2 = "ciao";
		assertSame("Con il costruttore dovrebbero essere lo stesso",s1, s2);
	}
}
