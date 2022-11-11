package fireDetection.observable;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Subject {

	private final List<Observer> observers = new ArrayList<Observer>();

	public boolean notifyObservers() {

		this.getObservers().forEach(elem -> elem.update(this));
		
		return true;
	}	

	public void addObserver(Observer obs) {
		this.getObservers().add(obs);
	}

	public void removeObserver(Observer obs) {
		this.getObservers().remove(obs);
	}

}
