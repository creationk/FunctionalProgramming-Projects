package com.test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class FP23_StreamSquaresOfFirstNnumbersStartingFromI {

	public void test(int I, int N) {
		Supplier<IntStream> intStreamSupplier = () -> IntStream.rangeClosed(I, N);
		System.out.println(intStreamSupplier.get().map(x -> x * x).boxed().collect(Collectors.toList()));
	}

	@Test
	public void testWithInputs() {
		test(1, 5);
	}
}