package com.in28minutes.mockito.mockitodemo;

public class SomeBusinessImpl {

	private DataService dataService;
}

interface DataService {

	int[] retrieveAllData();
}