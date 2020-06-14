package com.test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class FP25_LazyStreamOperations {
	Supplier<Stream<String>> stringStream = () -> Stream.of("Jack", "Jill", "Hill", "Today");

	static {

	}

	@Test
	public void ToUpperCaseAndFilter5LetterAndFindFirst() {
		List <String> list = stringStream.get().collect(Collectors.toList());
		list.replaceAll(String::toUpperCase);
		
		System.out.println(list);
		
		list.removeIf(x->x.length()<5);
		
		System.out.println(list);
	}

}