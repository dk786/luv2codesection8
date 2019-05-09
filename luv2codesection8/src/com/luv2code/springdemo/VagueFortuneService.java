package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class VagueFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "it could go either way";
	}

}
