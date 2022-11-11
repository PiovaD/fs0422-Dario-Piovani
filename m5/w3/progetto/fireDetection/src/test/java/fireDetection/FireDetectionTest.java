package fireDetection;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import fireDetection.model.ControlCenter;
import fireDetection.model.ControlCenterHttpCall;
import fireDetection.model.Probe;

public class FireDetectionTest {
	
	ControlCenter cc;

	@Before
	public void set() {
		this.cc = new ControlCenter(1L, new ControlCenterHttpCall());
	}

	@Test
	public void addObserverTest() {		 

		Probe p = new Probe(1L, 123.45, 67.8);
		
		p.addObserver(cc);
		
		assertTrue(p.getObservers().contains(cc));
	}
	
	@Test
	public void removeObserverTest() {

		Probe p = new Probe(1L, 123.45, 67.8);
		
		p.addObserver(cc);
		
		p.removeObserver(cc);
		
		assertFalse(p.getObservers().contains(cc));
	}
	
	
	@Test
	public void overTresholdTest() {

		Probe p = new Probe(1L, 123.45, 67.8);
		
		p.addObserver(cc);
		
		Executable execute = new Executable() {

			@Override
			public void execute() throws Throwable {
				p.setSmokeLevel(p.getSMOKE_THRESHOLD() + 1);

			}
		};

		assertThrows(RuntimeException.class, execute);
	}
	
	@Test
	public void equalTresholdTest() {

		Probe p = new Probe(1L, 123.45, 67.8);
		
		p.addObserver(cc);
		
		Executable execute = new Executable() {

			@Override
			public void execute() throws Throwable {
				p.setSmokeLevel(p.getSMOKE_THRESHOLD());

			}
		};

		assertDoesNotThrow(execute);
	}
	
	@Test
	public void lowerTresholdTest() {

		Probe p = new Probe(1L, 123.45, 67.8);
		
		p.addObserver(cc);
		
		Executable execute = new Executable() {

			@Override
			public void execute() throws Throwable {
				p.setSmokeLevel(p.getSMOKE_THRESHOLD()-1);

			}
		};

		assertDoesNotThrow(execute);
	}
	
}
