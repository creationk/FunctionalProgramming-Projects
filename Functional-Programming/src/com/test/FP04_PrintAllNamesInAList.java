package com.test;

import java.util.List;

import org.junit.Test;

public class FP04_PrintAllNamesInAList {
	public static final List<String> namesList = List.of("John", "Ron", "Nobel", "Jack", "Jesse", "Jane", "James",
			"Christy");

	@Test
	public void test() {
		System.out.println(":::::::::: test :::::::::");				
		for (String a : namesList) {
			System.out.println(a);
		}
		System.out.println("::::::::::: Initial list :::::::::::");
		System.out.println(namesList);
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");				
		namesList.stream().forEach(Functions.print);
	}
}
