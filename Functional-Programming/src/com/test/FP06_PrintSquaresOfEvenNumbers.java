package com.test;

import java.util.List;

import org.junit.Test;

public class FP06_PrintSquaresOfEvenNumbers {
	public static final List<Integer> numberList = List.of(1, 2, 3, 4, 5);

	@Test
	public void test() {
		for (Integer a : numberList) {
			if (a % 2 == 0)
				System.out.println(Math.pow(a, 2));
		}
	}

	@Test
	public void testFunctional() {
//		numberList.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.println(Math.pow(num, 2)));
		numberList.stream().filter(num -> num % 2 == 0).map(num -> Math.pow(num, 2)).forEach(System.out::println);
	}
}
