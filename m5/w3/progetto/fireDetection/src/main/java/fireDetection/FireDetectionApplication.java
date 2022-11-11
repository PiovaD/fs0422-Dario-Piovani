package fireDetection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fireDetection.model.ControlCenter;
import fireDetection.model.ControlCenterHttpCall;
import fireDetection.model.Probe;
import fireDetection.utils.LogColor;

@SpringBootApplication
public class FireDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FireDetectionApplication.class, args);
		
		ControlCenter cc = new ControlCenter(1L, new ControlCenterHttpCall());		
		
		Probe p1 = new Probe(1L, 420.9, 709.3);
		Probe p2 = new Probe(2L, 44.9, 6.3);
		
		p1.addObserver(cc);	
		p2.addObserver(cc);	
		
		LogColor.infoMessage("Start");;
				
		p1.setSmokeLevel(4); 	
		p1.setSmokeLevel(6); 
		p2.setSmokeLevel(10);
		
	}

}
