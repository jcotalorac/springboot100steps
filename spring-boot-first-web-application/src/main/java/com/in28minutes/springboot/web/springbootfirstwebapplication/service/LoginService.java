package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String userid, String password) {
		return userid.equals("in18minutes") && password.equals("dummy");
	}
}
