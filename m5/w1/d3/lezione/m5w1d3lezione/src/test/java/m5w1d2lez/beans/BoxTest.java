package m5w1d2lez.beans;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import m5w1d2lez.classes.Box;

@RunWith(Parameterized.class)
public class BoxTest {

	private int a, b, c;

	public BoxTest(int a, int b, int c) {

		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Parameters
	public static Collection<Object[]> params() {
		return Arrays.asList(new Object[][] { 
			{ 10, 5, 2 },
			{ 20, 10, 2 },
			{ 100, 5, 3 },
			{ 20, 10, 50 } 
			});
	}

	@Test
	public void test() {

		Box box = new Box(b, c);
		
		assertEquals(a, box.area());
	}

}
