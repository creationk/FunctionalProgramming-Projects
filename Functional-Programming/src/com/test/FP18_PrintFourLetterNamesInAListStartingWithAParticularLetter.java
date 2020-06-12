package com.test;

import java.util.List;
import java.util.function.BiPredicate;

import org.junit.Test;

public class FP18_PrintFourLetterNamesInAListStartingWithAParticularLetter {
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
		namesList.stream().filter(x -> Functions.b.test(x, "J")).forEach(System.out::println);
	}

}
