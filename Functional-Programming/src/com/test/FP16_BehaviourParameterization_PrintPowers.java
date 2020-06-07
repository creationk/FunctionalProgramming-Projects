package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import org.junit.Test;

public class FP16_BehaviourParameterization_PrintPowers {
	private static final List<Integer> numberList;

	static {
		List<Integer> tempList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			tempList.add(r.nextInt(99999));
		}
		numberList = tempList;
	}


	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");	
		
		filterAndPrint(Functions.filterEven);
		System.out.println("-----");
		filterAndPrint(Functions.filterOdd);
	}


	private void filterAndPrint(Predicate <Integer> filterCondition) {
		numberList.stream()
			.filter(filterCondition)
				.forEach(Functions.print);
	}
}
