package com.in28minutes.mockito.mockitodemo;

import org.junit.Test;

public class SomeBusinessTest {

	@Test
	public void testFindGreatestFromAllData() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		businessImpl.findGreatestFromAllData();
	}

}
