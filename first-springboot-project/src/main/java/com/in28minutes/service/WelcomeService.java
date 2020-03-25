package com.in28minutes.service;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {
	public String retrieveWelcomeMessage() {
		return "Good Morning updated!";
	}
}