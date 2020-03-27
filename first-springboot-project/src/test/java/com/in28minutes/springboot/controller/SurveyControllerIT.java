package com.in28minutes.springboot.controller;

import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

import org.junit.Before;
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
import com.in28minutes.springboot.model.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Before
	public void before() {
		headers.add("Authorization", createHttpAuthenticationHeadersValue("user1", "secret1"));
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testRetrieveSurveyQuestion() {

		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(
				createURLWithPort("/surveys/Survey1/questions/Question1"), HttpMethod.GET, requestEntity, String.class);
		System.out.println("Response: " + responseEntity.getBody());

		String expected = "{\"id\":\"Question1\",\"description\":\"Largest Country in the World\",\"correctAnswer\":\"Russia\",\"options\":[\"India\",\"Russia\",\"United States\",\"China\"]}";
		JSONAssert.assertEquals(expected, responseEntity.getBody(), true);
		assertTrue(responseEntity.getBody().contains("\"id\":\"Question1\""));
	}

	@Test
	public void testAddQuestion() {

		Question question = new Question("Question1", "Largest Country in the World", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));
		HttpEntity<Question> requestEntity = new HttpEntity<Question>(question, headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(createURLWithPort("/surveys/Survey1/questions"),
				HttpMethod.POST, requestEntity, String.class);

		String actual = responseEntity.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(actual.contains("/surveys/Survey1/questions"));
		System.out.println("Actual: " + actual);

	}

	private String createURLWithPort(String retrieveAllQuestions) {
		return "http://localhost:" + port + retrieveAllQuestions;
	}

	private String createHttpAuthenticationHeadersValue(String userId, String password) {
		String auth = userId + ":" + password;

		byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));

		String headerValue = "Basic " + new String(encodeAuth);

		return headerValue;
	}
}
