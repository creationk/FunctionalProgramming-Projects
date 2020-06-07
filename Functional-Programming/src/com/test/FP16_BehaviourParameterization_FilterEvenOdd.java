package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

public class FP16_BehaviourParameterization_FilterEvenOdd {
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
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");

		List <Integer> resultList = new ArrayList<>();
		resultList = calculatePower(numberList, 2);
		System.out.println(resultList);
		System.out.println("--------");
		resultList=calculatePower(numberList, 3);
		System.out.println(resultList);


	}

	private List<Integer> calculatePower(List<Integer> numList, int exponent) {
		Function<Integer, Integer> mapper = x -> (int) Math.pow(x, exponent);
		return numList.stream().map(mapper).collect(Collectors.toList());
	}

}
