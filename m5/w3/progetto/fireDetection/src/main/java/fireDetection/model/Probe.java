package fireDetection.model;

import fireDetection.observable.Subject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Probe extends Subject {

	public final int SMOKE_THRESHOLD = 5;

	private Long id;

	private double latitude;
	private double longitude;
	private int smokeLevel = 0;

	public Probe(Long id, double latitude, double longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;

		if (smokeLevel > SMOKE_THRESHOLD) {
			super.notifyObservers();
		}
	}

}
