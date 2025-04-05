package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private static final Logger logger = LogManager.getLogger();

    // Start test
    // Finish test
    // Info log

    public static void startTest (String testName) {
        logger.info("===== Execution started: " + testName +" =====");
    }

    public static void finishTest (String testName) {
        logger.info("===== Execution finished: " + testName +" =====");
    }

    public static void infoTest (String message) {
        logger.info(message);
    }

}
