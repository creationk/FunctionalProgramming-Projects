package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

public class FP10_PrintSquaresOfEvenNumbersAndAddThem {
	private static final List<Integer> numberList;

	static {
		List<Integer> tempList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			tempList.add(r.nextInt(6));
		}
		numberList = tempList;
		System.out.println("::::::::::: Initial list :::::::::::");
		System.out.println(numberList);
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
		Predicate<Integer> predicate = num -> num % 2 == 0;
		Function<Integer, Integer> mapperFunction = num -> num * num;
		Integer i = numberList.stream()
				.filter(predicate)
					.map(mapperFunction)
						.reduce(0,Integer::sum);
	}
}
