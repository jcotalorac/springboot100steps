package com.in28minutes.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	public void test() {
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.size()).thenReturn(10);
		assertEquals(10, listMock.size());
	}

}
