package com.test;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.junit.Test;

public class FP24_CalculateFactorial {

	@Test
	public void testWithInputs() {
		int i = 30;
		Supplier<IntStream> input = () -> IntStream.rangeClosed(1, i);
		System.out.println(
				input.get().mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply)
				);

	}
}