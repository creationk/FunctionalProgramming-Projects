package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class FP10_PrintSquaresOfEvenNumbersAndAddThem {
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
		System.out.println("::::::::::::::: test :::::::::::::::");
		Integer sum=0;
		for (Integer a : numberList) {
			if (a % 2 == 0)
				sum=sum+a*a;
		}
		System.out.println(sum);
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");
		System.out.println(numberList.stream()
				.filter(num -> num % 2 == 0)
					.map(num -> num * num)
						.reduce(0,Integer::sum));
	}
}
