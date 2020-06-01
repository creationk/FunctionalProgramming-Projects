package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class FP12_PrintAllNamesInAListAndSortBasedOnTheLength {
	public static final List<String> namesList = List.of("John", "Ron", "Nobel", "Jack", "Jesse", "Jane", "James",
			"Christy");
	static {
		System.out.println("::::::::::: Initial list :::::::::::");
		System.out.println(namesList);
	}

	@Test
	public void test() {
		System.out.println(":::::::::: test :::::::::");
		List<String> newList = new ArrayList(namesList);
		Collections.sort(newList, new SortByName());
		for (String a : newList) {
			System.out.println(a);
		}
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");
		namesList.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}
}

class SortByName implements Comparator<String> {
	public int compare(String a, String b) {
		return a.length() - b.length();
	}
}
