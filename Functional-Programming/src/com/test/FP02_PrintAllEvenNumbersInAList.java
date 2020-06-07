package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class FP02_PrintAllEvenNumbersInAList {
	private static final List<Integer> numberList;

	static {
		List<Integer> tempList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			tempList.add(r.nextInt(99999));
		}
		numberList = tempList;
		System.out.println("::::::::::: Initial list :::::::::::");
		System.out.println(numberList);
	}
	@Test
	public void test() {
		System.out.println(":::::::::: test :::::::::");		
		for (Integer a : numberList) {
			if (a % 2 == 0)
				System.out.println(a);
		}
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");		
		numberList.stream()
			.filter(Functions.filterEven)
				.forEach(Functions.print);
	}
}
