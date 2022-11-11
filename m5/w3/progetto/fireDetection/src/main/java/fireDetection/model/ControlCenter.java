package fireDetection.model;

import fireDetection.model.interfaces.IControlCenter;
import fireDetection.observable.Observer;
import fireDetection.observable.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ControlCenter implements Observer{
	
	private Long id;
	
	private IControlCenter controlCenter;

	@Override
	public void update(Subject obj) {
		controlCenter.fireDetector((Probe) obj);		
	}



}
