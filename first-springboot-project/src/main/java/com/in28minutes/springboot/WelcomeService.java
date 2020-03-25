package com.in28minutes.springboot;

import org.springframework.stereotype.Component;

@Component
class WelcomeService {
	public String retrieveWelcomeMessage() {
		return "Good Morning updated!";
	}
}