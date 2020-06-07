package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

public class FP15_Function_Consumer_Predicate_Supplier {
	private static final List<Integer> numberList;

	static {
		List<Integer> tempList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			tempList.add(r.nextInt(6));
		}
		numberList = tempList;
		System.out.println("::::::::::: Initial list :::::::::::");
		System.out.println(numberList);
	}

	/*
	 * 1. Consumer is a functional interface that accepts a single input and returns no output 
	 * 2. A Supplier is a interface which indicates that this implementation is a supplier of results. 
	 * 	  It has only one method get(). 
	 * 3. A Predicate interface represents a boolean-valued-function of an argument 
	 * 4. A Function interface is more of a generic one that takes one argument and produces a result
	 */		
	
	@Test
	public void testFunctional() {
		Predicate<Integer> predicate = x -> x % 2 == 0;
		Function<Integer, Integer> mapperFunction = num -> num * num;
		Consumer<Integer> consumer = System.out::println;
		
		numberList.stream().filter(predicate).map(mapperFunction).forEach(consumer);
	}


}
