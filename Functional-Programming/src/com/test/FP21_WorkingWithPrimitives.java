package com.test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class FP21_WorkingWithPrimitives {

	@Test
	public void test() {
		int[] intArray = { 1, 2, 3, 4, 5, 6 };

		/*
		 * A Stream should be operated on (invoking an intermediate or terminal stream
		 * operation) only once. A Stream implementation may throw IllegalStateException
		 * if it detects that the Stream is being reused.
		 */

		System.out.println(":::::::::::::: IntStream ::::::::::::::");
		Arrays.stream(intArray).forEach(System.out::println);
		System.out.println(":::::::::::::: Sum, Aveage & Count ::::::::::::::");
		System.out.println(Arrays.stream(intArray).sum() + "," + Arrays.stream(intArray).average().getAsDouble() + ","
				+ Arrays.stream(intArray).count());

	}
}