package com.in28minutes.springboot.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.springboot.model.Question;
import com.in28minutes.springboot.service.SurveyService;

@RunWith(SpringRunner.class)
@WebMvcTest(SurveyController.class)
public class SurveyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SurveyService surveyService;

	@Test
	public void testRetrieveDetailsForQuestion() throws Exception {

		Question mockQuestion = new Question("Question1", "Largest Country in the World", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));

		when(surveyService.retrieveQuestion(anyString(), anyString())).thenReturn(mockQuestion);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/surveys/Survey1/questions/Question1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"id\":\"Question1\",\"description\":\"Largest Country in the World\",\"correctAnswer\":\"Russia\",\"options\":[\"India\",\"Russia\",\"United States\",\"China\"]}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}

}
