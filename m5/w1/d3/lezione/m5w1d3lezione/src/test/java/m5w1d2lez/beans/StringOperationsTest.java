package m5w1d2lez.beans;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import m5w1d2lez.classes.StringOperations;

@RunWith(Parameterized.class)
public class StringOperationsTest {
	
	private String p;
	private int l;
	
	public StringOperationsTest(String p, int l) {
		this.p = p;
		this.l = l;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][] { 
				{ "Ciao", 8},
				{ "a", 2 },
				{ "Carlo", 3 },
				{ "Sandro", 50 } 
				});
	}
	

	@Test
	public void test() {
		StringOperations so = new StringOperations(p);
		assertEquals(l, so.getLength());
	}

}
