package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {

	public ModelAndView handleException() {
		return null;
	}
}
