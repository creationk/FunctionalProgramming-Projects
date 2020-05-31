package com.test;

import java.util.List;

import org.junit.Test;

public class FP04_PrintAllNamesInAList {
	public static final List<String> namesList = List.of("John", "Ron", "Nobel", "Jack", "Jesse", "Jane", "James",
			"Christy");

	@Test
	public void test() {
		for (String a : namesList) {
			System.out.println(a);
		}
	}

	@Test
	public void testFunctional() {
		namesList.stream().forEach(System.out::println);
	}
}
