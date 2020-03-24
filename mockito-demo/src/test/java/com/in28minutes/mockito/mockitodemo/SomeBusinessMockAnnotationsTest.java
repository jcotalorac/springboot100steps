package com.in28minutes.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class SomeBusinessMockAnnotationsTest {
	
	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	private SomeBusinessImpl businessImpl;

	@Test
	public void testFindGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });

		int result = businessImpl.findGreatestFromAllData();
		assertEquals(24, result);
	}

}
