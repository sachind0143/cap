package com.flightbooking.automation.utils;

//Create logger instance
import org.apache.logging.log4j.LogManager;
//Writes log messages
import org.apache.logging.log4j.Logger;

public class LoggerUtils {
	private static Logger logger = LogManager.getLogger(LoggerUtils.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }
}
