package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigApp {

	public static void main(String[] args) {
		// load spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// retrieve bean from spring container
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		Coach theOtherCoach = context.getBean("swimCoach", Coach.class);
		//TestPackageTestClass testMessage = context.getBean("testPackageTestClass", TestPackageTestClass.class);
		
		//testMessage.testMethod();

		boolean result = (theCoach == theOtherCoach);

		if (result) {
			System.out.println("\nponting to the same object" + theCoach + " " + theOtherCoach);
		} else {
			System.out.println("\npointing to different objects " + theCoach + " " + theOtherCoach);
		}
		
		System.out.println(theCoach.getTodaysFortune());
		
		context.close();
	}
}
