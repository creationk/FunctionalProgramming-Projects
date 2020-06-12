package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

public class FP20_SortAllNumbersInAList {
	private static final List<Integer> numberList;
	Function<Integer, Integer> recursiveSomeOfDigits = x -> {
		int z = x;
		do {
			x = z;
			int y = 0;
			do {
				y = y + x % 10;
				x = x / 10;
			} while (x > 0);
			z = y;
		} while (z > 10);
		return z;

	};

	static {
		List<Integer> tempList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			tempList.add(r.nextInt(50));
		}
		numberList = tempList;
		System.out.println("::::::::::: Initial list :::::::::::");
		System.out.println(numberList);
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");
//		System.out.println(numberList.stream().sorted().collect(Collectors.toList()));

		System.out.println(
				numberList.stream().sorted(Comparator.comparing(recursiveSomeOfDigits)).collect(Collectors.toList()));
	}

}
