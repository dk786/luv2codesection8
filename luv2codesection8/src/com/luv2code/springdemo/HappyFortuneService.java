package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		System.out.println(">> Initialising the fortune method");
		return "today is your lucky day";
	}

}
