package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class FP11_PrintDistinctNumbersInAListAndSortThem {
	private static final List<Integer> numberList;

	static {
		List<Integer> tempList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			tempList.add(r.nextInt(4));
		}
		numberList = tempList;
		System.out.println("::::::::::: Initial list :::::::::::");
		System.out.println(numberList);
	}

	@Test
	public void test() {
		System.out.println("\n::::::::::::::: test :::::::::::::::");
		List<Integer> filteredList = new ArrayList<>();
		for (Integer i : numberList) {
			if (!filteredList.contains(i))
				filteredList.add(i);
		}
		Collections.sort(filteredList);
		for (Integer i : filteredList) {
			System.out.println(i);
		}
	}

	@Test
	public void testFunctional() {
		System.out.println("\n:::::::::: test functional :::::::::");
		numberList.stream().distinct().sorted().forEach(System.out::println);
	}
}
