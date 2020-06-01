package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

public class FP14_StoreLengthsOfAllNamesInAList {
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
		List<Integer> lengthList = new ArrayList<>();
		for (String a : newList) {
			lengthList.add(a.length());
		}
		System.out.println(lengthList);
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");
		List<Integer> lengthList = namesList.stream().map(String::length).collect(Collectors.toList());
		System.out.println(lengthList);
	}
}
