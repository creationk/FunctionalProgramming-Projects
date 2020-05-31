package com.test;

import java.util.List;

import org.junit.Test;

public class FP03_PrintAllOddNumbersInAList {
	public static final List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
			18, 19, 20);

	@Test
	public void test() {
		for (Integer a : numberList) {
			if (a % 2 != 0)
				System.out.println(a);
		}
	}

	@Test
	public void testFunctional() {
		numberList.stream()
			.filter(num -> num % 2 != 0)
				.forEach(System.out::println);
	}
}
