package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		System.out.println(">> Initialising the fortune method");
		return "today is a sad day";
	}

}
