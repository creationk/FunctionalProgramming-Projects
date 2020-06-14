package com.test;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;

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

		System.out.println(":::::::: Working with a range of numbers ::::::::");
		Supplier<IntStream> intStreamSupplier = () -> IntStream.range(1, 7);

		System.out.println(intStreamSupplier.get().sum() + "," + intStreamSupplier.get().average().getAsDouble() + ","
				+ intStreamSupplier.get().count());

		System.out.println(":::::::: Stream iteration ::::::::");
		Supplier<IntStream> iteratingSupplier = () -> IntStream.iterate(1, i -> i + 3).limit(5);
		System.out.println(iteratingSupplier.get().sum() + "," + iteratingSupplier.get().average().getAsDouble() + ","
				+ iteratingSupplier.get().count());

	}
}