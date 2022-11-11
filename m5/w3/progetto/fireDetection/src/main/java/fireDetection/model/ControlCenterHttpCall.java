package fireDetection.model;

import fireDetection.model.interfaces.IControlCenter;
import fireDetection.utils.LogColor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ControlCenterHttpCall implements IControlCenter {

	private static final String baseUrl = "http://host/alarm";

	@Override
	public String fireDetector(Probe probe) {
		log.warn(LogColor.RED("Alarm smoke detector n. " + probe.getId() + " latitude: " + probe.getLatitude() + " longitude: "
				+ probe.getLongitude() + " smoke particles detected: " + probe.getSmokeLevel()));

		String completeUrl = baseUrl + "?=idDetector=" + probe.getId() + "&lat=" + probe.getLatitude() + "&lon="
				+ probe.getLongitude() + "&smokelevel=" + probe.getSmokeLevel();
		log.warn(LogColor.YELLOW(completeUrl));

		return completeUrl;
	}

}
