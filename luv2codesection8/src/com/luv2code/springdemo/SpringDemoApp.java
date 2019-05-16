package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com\\luv2code\\springdemo\\application-context.xml");
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		TennisCoach myCoach = (TennisCoach)theCoach;
		System.out.println(myCoach.coachDetails());
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getTodaysFortune());
		
		context.close();
	}

}