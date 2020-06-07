package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.Test;

public class FP17_DoubleAllNumbersInAList {
	private static final List<Integer> numberList = new ArrayList<>();

	static {

		numberList.add(Functions.randomIntegerSupplier.get());
		numberList.add(Functions.randomIntegerSupplier.get());
		numberList.add(Functions.randomIntegerSupplier.get());

		System.out.println("::::::::::: Initial list :::::::::::");
		System.out.println(numberList);
	}

	@Test
	public void testFunctional() {
		System.out.println(":::::::::: test functional :::::::::");
		System.out
				.println(numberList.stream().map(t -> Functions.doubleOperator.apply(t)).collect(Collectors.toList()));

	}
}
