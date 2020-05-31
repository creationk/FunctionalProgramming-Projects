package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class FP06_PrintSquaresOfEvenNumbers {
	private static final List<Integer> numberList;

	static {
		List<Integer> tempList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			tempList.add(r.nextInt(5));
		}
		numberList = tempList;
	}
	@Test
	public void test() {
		System.out.println(":::::::::: test :::::::::");		
		for (Integer a : numberList) {
			if (a % 2 == 0)
				System.out.println(Math.pow(a, 2));
		}
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");				
//		numberList.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.println(Math.pow(num, 2)));
		numberList.stream().filter(num -> num % 2 == 0).map(num -> Math.pow(num, 2)).forEach(System.out::println);
	}
}
