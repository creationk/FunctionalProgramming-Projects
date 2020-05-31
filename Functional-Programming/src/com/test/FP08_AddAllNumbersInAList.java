package com.test;

import java.util.List;

import org.junit.Test;

public class FP08_AddAllNumbersInAList {
	public static final List<Integer> numberList = List.of(1, 2, 3, 4);

	@Test
	public void test() {
		Integer sum = 0;
		for (Integer a : numberList) {
			sum = sum + a;
		}
		System.out.println(sum);
	}

	@Test
	public void testFunctional() {
		System.out.println(numberList.stream().reduce(0,Integer::sum));
	}

}
