package com.test;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

public class FP26_ModifyingLists {
	Supplier<Stream<String>> stringStream = () -> Stream.of("Jack", "Jill", "Hill", "Today");

	static {

	}

	@Test
	public void ToUpperCaseAndFilter5LetterAndFindFirst() {
		System.out.println(
				stringStream.get().peek(x->System.out.println("After stream: "+x))
				.filter(x -> x.length() == 5).peek(x->System.out.println("After filter: "+x))
				.map(String::toUpperCase).peek(x->System.out.println("After toUpperCase: "+x))
				.findFirst().get()
				);
	}

}