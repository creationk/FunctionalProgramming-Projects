package com.test;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class FP22_StreamFirstNnumbersStartingFromI {

	public void test(int I, int N) {
		Supplier<IntStream> intStreamSupplier = () -> IntStream.rangeClosed(I, N);
		System.out.println(intStreamSupplier.get().sum());
		
	}

	@Test
	public void testWithInputs() {
		test(1, 5);
	}
}