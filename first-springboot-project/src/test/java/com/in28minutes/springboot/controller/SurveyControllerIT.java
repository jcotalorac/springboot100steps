package com.in28minutes.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

	@LocalServerPort
	private int port;

	@Test
	public void test() {
		String url = "http://localhost:" + port + "/surveys/Survey1/questions/Question1";
		TestRestTemplate restTemplate = new TestRestTemplate();
		String output = restTemplate.getForObject(url, String.class);
		System.out.println("Response: " + output);
	}
}
