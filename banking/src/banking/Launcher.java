package banking;

import logger.Logger;
import logger.LoggerFactory;

public class Launcher {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger();
		logger.info("truc");
		logger.error("bidule");
	}
}