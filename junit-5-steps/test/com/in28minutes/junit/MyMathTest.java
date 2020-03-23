package com.in28minutes.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyMathTest {

	MyMath myMath = new MyMath();

	@Before
	public void before() {
		System.out.println("Before");
	}
	
	@Test
	public void sumWith3Numbers() {
		System.out.println("Test1");
		assertEquals(6, myMath.sum(new int[] { 1, 2, 3 }));
	}

	@Test
	public void sumWith1Number() {
		System.out.println("Test2");
		assertEquals(3, myMath.sum(new int[] { 3 }));
	}
}
