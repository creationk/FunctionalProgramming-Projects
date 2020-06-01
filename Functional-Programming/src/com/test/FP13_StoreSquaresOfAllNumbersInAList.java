package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Test;

public class FP13_StoreSquaresOfAllNumbersInAList {
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
		List<Integer> squareList = new ArrayList<>();

		for (Integer i : numberList) {
			squareList.add((int) Math.pow(i, 2));
		}
		System.out.println(squareList);
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");
		List<Integer> squareList = numberList.stream().map(x -> (int) Math.pow(x, 2)).collect(Collectors.toList());
		System.out.println(squareList);
	}
}
