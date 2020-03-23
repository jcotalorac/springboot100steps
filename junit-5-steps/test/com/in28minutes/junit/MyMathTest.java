package com.in28minutes.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyMathTest {

	MyMath myMath = new MyMath();

	@Test
	public void sumWith3Numbers() {

		int result = myMath.sum(new int[] { 1, 2, 3 });

		assertEquals(6, result);
	}

	@Test
	public void sumWith1Number() {

		int result = myMath.sum(new int[] { 3 });

		assertEquals(3, result);
	}
}
