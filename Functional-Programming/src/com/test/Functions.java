package com.test;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Functions {
	public static final Predicate<Integer> filterEven = x -> x % 2 == 0;
	public static final Predicate<Integer> filterOdd = x -> x % 2 == 1;
	public static final Function<Integer, Double> squareFunction = num -> Math.pow(num, 2);
	public static final Consumer<Object> print = System.out::println; //accept
	public static final BiConsumer<Integer, String> bc = (num,str)->System.out.println(num+","+str);
	public static final BinaryOperator<Integer> sumAccumulator = Integer::sum;
	public static final BinaryOperator<Integer> sumOperator = (x, y) -> x + y;
	public static final Supplier<Integer> randomIntegerSupplier = () -> {return new Random().nextInt(5);}; //get
	public static final UnaryOperator<Integer> doubleOperator = x->2*x;
	public static final BiPredicate<String, String> b = (str, startsWith) -> {
		return str.length() == 4 && str.startsWith(startsWith);
	};

}
