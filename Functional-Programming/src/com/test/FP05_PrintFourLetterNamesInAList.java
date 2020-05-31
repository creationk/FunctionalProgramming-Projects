package com.test;

import java.util.List;

import org.junit.Test;

public class FP05_PrintFourLetterNamesInAList {
	public static final List<String> namesList = List.of("John", "Ron", "Nobel", "Jack", "Jesse", "Jane", "James",
			"Christy");

	@Test
	public void test() {
		System.out.println(":::::::::: test :::::::::");		
		for (String name : namesList) {
			if (name.length() == 4) {
				System.out.println(name);
			}
		}
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");						
		namesList.stream().filter(a -> a.length() == 4).forEach(System.out::println);
	}
}
