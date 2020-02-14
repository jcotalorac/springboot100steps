package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

public class LoginService {

	public boolean validateUser(String userid, String password) {
		return userid.equals("in18minutes") && password.equals("dummy");
	}
}
