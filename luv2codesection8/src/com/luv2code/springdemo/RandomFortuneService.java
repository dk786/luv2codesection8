package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	Random random = new Random();
	String[] fortunes = {"this is going to be a tough week", "All good things come to those who wait", "rockstar week"};
	
	int myRandom = random.nextInt(fortunes.length);
	
	@Override
	public String getFortune() {
		return fortunes[myRandom];
	}

}
