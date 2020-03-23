package com.in28minutes.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyMathTest {

	@Test
	public void sumWith3Numbers() {
		MyMath myMath = new MyMath();

		int result = myMath.sum(new int[] { 1, 2, 3 });

		assertEquals(6, result);
	}
}
