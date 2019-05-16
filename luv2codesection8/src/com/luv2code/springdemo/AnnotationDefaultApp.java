package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDefaultApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context2.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach theOtherCoach = context.getBean("tennisCoach", Coach.class);

		boolean result = (theCoach == theOtherCoach);

		if (result) {
			System.out.println("\nponting to the same object" + theCoach + " " + theOtherCoach);
		} else {
			System.out.println("\npointing to different objects " + theCoach + " " + theOtherCoach);
		}
		
		context.close();
	}
}
