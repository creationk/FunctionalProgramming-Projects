package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import org.junit.Test;

public class FP19_Parallelizing {

	private static final List<String> integerList = new ArrayList<>();

	static {
		Supplier<Integer> intSupplier = () -> new Random().nextInt(5);
		for (int i = 0; i < 200000; i++) {
			integerList.add(intSupplier.get().toString());
		}

	}

	@Test
	public void testStream() {
		System.out.println(integerList.stream().reduce(String::concat).get().substring(0, 5));
	}

	@Test
	public void testParallelStream() {
		System.out.println(integerList.parallelStream().reduce(String::concat).get().substring(0, 5));
	}

}
