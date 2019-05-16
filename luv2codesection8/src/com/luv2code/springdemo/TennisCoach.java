package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class TennisCoach implements Coach {

	public TennisCoach() {
		System.out.println(">> Initialising the tennis coach constructor");

	}

	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	@Value("${my.email}")
	private String email;

	@Value("${my.team}")
	private String team;

	@Override
	public String getDailyWorkout() {
		return "practice your backhand today";
	}

	@Override
	public String getTodaysFortune() {
		return fortuneService.getFortune();
	}

	public String coachDetails() {
		return "My details are: " + email + " " + team;
	}
	
	
	// define my init method
	@PostConstruct
	public void intiMethod() {
		System.out.println(">> initilising with preconstruct");
		
	}
	
	// define my destroy method
	@PreDestroy
	public void destroyMethod() {
		System.out.println(">> Destroying the object with post destroy");
	}

}
