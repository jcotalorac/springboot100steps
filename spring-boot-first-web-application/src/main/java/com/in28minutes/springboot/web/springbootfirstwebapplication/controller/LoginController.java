package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginMessage(ModelMap model) {
		//model.put("name", name);
		//System.out.println("name is: " + name);
		return "login";
	}
}
