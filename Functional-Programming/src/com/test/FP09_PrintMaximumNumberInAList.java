package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class FP09_PrintMaximumNumberInAList {
	private static final List<Integer> numberList;

	static {
		List<Integer> tempList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 1000000; i++) {
			tempList.add(r.nextInt(99999));
		}
		numberList = tempList;
	}

	@Test
	public void test() {
		System.out.println(":::::::::: test :::::::::");		
		Integer max = Integer.MIN_VALUE;
		for (int i = 0; i < numberList.size(); i++) {
			max = max > numberList.get(i) ? max : numberList.get(i);
		}
		System.out.println(max);
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");				
		// System.out.println(numberList.stream().reduce((x, y) -> x > y ? x :
		// y).get());
		System.out.println(numberList.stream().reduce(Integer.MIN_VALUE, Math::max));
	}

}
