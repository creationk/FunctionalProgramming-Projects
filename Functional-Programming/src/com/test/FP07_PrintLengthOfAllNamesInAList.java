package com.test;

import java.util.List;

import org.junit.Test;

public class FP07_PrintLengthOfAllNamesInAList {
	public static final List<String> namesList = List.of("John", "Ron", "Nobel", "Jack", "Jesse", "Jane", "James",
			"Christy");

	@Test
	public void test() {
		System.out.println(":::::::::: test :::::::::");						
		for (String a : namesList) {
			System.out.println(a + "," + a.length());
		}
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");						
		namesList.stream().forEach(a -> System.out.println(a + "," + a.length()));
	}
}
