package com.luv2code.springdemo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author Dawood Khan
 * 
 * @category = Configuration. In Spring 5.1, the Spring Development team changed
 *           the logging levels internally. As a result, by default you will no
 *           longer see the red logging messages at the INFO level. This
 *           configuration enables the default logging for your app again NB:
 *           Not required once the log4j 2 dependencies have been added to the
 *           project, spring seems to pick them up and auto wire them if it can
 *           find them
 */

public class MyLoggingConfig {
	private String rootLoggerLevel;
	private String printedLoggerLevel;

	public void setRootLoggerLevel(String rootLoggerLevel) {
		this.rootLoggerLevel = rootLoggerLevel;
	}

	public void setPrintedLoggerLevel(String printedLoggerLevel) {
		this.printedLoggerLevel = printedLoggerLevel;
	}

	public void initLogger() {

		// parse levels
		Level rootLevel = Level.parse(rootLoggerLevel);
		Level printedLevel = Level.parse(printedLoggerLevel);

		// get logger for app context

		Logger applicationLoggerContext = Logger
				.getLogger(AnnotationConfigApplicationContext.class.getName());

		// get parent logger
		Logger loggerParent = applicationLoggerContext.getParent();

		// set root logging level
		loggerParent.setLevel(rootLevel);

		// set up the console handler
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(printedLevel);
		consoleHandler.setFormatter(new SimpleFormatter());

		// add handler to the logger
		loggerParent.addHandler(consoleHandler);

	}

}
