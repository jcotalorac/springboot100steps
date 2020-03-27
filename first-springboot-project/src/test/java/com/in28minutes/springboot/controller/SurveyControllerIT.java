package com.in28minutes.springboot.controller;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

	@LocalServerPort
	private int port;

	@Test
	public void testRetrieveSurveyQuestion() {
		String url = "http://localhost:" + port + "/surveys/Survey1/questions/Question1";
		TestRestTemplate restTemplate = new TestRestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entityRequest = new HttpEntity<>(null, headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entityRequest, String.class);
		System.out.println("Response: " + responseEntity.getBody());

		String expected = "{\"id\":\"Question1\",\"description\":\"Largest Country in the World\",\"correctAnswer\":\"Russia\",\"options\":[\"India\",\"Russia\",\"United States\",\"China\"]}";
		JSONAssert.assertEquals(expected, responseEntity.getBody(), true);
		assertTrue(responseEntity.getBody().contains("\"id\":\"Question1\""));
	}
}
