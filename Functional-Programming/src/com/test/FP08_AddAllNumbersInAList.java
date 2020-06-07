package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;

import org.junit.Test;

public class FP08_AddAllNumbersInAList {
	private static final List<Integer> numberList;

	static {
		List<Integer> tempList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			tempList.add(r.nextInt(5));
		}
		numberList = tempList;
		System.out.println("::::::::::: Initial list :::::::::::");
		System.out.println(numberList);
	}

	@Test
	public void test() {
		System.out.println(":::::::::: test :::::::::");
		Integer sum = 0;
		for (Integer a : numberList) {
			sum = sum + a;
		}
		System.out.println(sum);
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");
		System.out.println(numberList.stream().reduce(Functions.sumOperator).get());
//		System.out.println(numberList.stream().reduce(0, Functions.sumAccumulator));
	}

}
