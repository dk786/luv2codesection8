package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	Random random = new Random();
	private String[] fortunes;
	int myRandom;

	@Value("${happy.fortune}")
	public String happy;

	@Value("${sad.fortune}")
	public String sad;

	@Value("${vague.fortune}")
	public String vague;

	@PostConstruct
	private void setupMyData() {
		fortunes = new String[] { happy, sad, vague };
		myRandom = random.nextInt(fortunes.length);
	}

	@Override
	public String getFortune() {
		return fortunes[myRandom];
	}

}
