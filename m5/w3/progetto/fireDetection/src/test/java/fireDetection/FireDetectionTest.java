package fireDetection;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import fireDetection.model.ControlCenter;
import fireDetection.model.ControlCenterHttpCall;
import fireDetection.model.Probe;

public class FireDetectionTest {
	
	ControlCenter cc= new ControlCenter(1L, new ControlCenterHttpCall());

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
		
		assertTrue(p.setSmokeLevel(p.getSMOKE_THRESHOLD() + 1));		

	}
	
	@Test
	public void equalTresholdTest() {

		Probe p = new Probe(1L, 123.45, 67.8);
		
		p.addObserver(cc);
		
		assertFalse(p.setSmokeLevel(p.getSMOKE_THRESHOLD()));
		
	}
	
	@Test
	public void lowerTresholdTest() {

		Probe p = new Probe(1L, 123.45, 67.8);
		
		p.addObserver(cc);
		
		assertFalse(p.setSmokeLevel(p.getSMOKE_THRESHOLD() - 1));
	}
	
}
