package lib;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Libraries {
	
	private static final Logger logger = LoggerFactory.getLogger(Libraries.class);

	public static void main(String[] args) {
		
		logger.debug("debug msg");
		logger.info("info msg");
		logger.error("error msg");

	}

}
