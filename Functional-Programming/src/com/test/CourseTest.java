package com.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

import com.app.Course;

public class CourseTest {
	private static List<Course> courses;
	private static Predicate<Course> scoreGT92 = course -> course.getReviewScore() > 92;
	private static BiPredicate<Integer, Integer> scoreFilter = (givenScore, testScore) -> givenScore > testScore;
	private static Function<Course, Integer> sortStudentNumberDesc = course -> {
		return course.getNoOfStudents();
	};

	static {
		courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));
		System.out.println("::::::::::::::: Initial List :::::::::::::::");
		courses.stream().forEach(System.out::println);
	}

	@Test
	public void testPrintAllReviewScoreGreaterThanX() {
		System.out.println("\n:::::::::::::: testPrintAllReviewScoreGreaterThanX ::::::::::::::");
		courses.stream().filter(x -> scoreFilter.test(x.getReviewScore(), 95)).forEach(System.out::println);
//		System.out.println(courses.stream().allMatch(course->scoreFilter.test(course.getReviewScore(),95)));
	}

	@Test
	public void testPrintAnyReviewScoreGreaterThanX() {
		System.out.println("\n:::::::::::::: testPrintAnyReviewScoreGreaterThanX ::::::::::::::");
		courses.stream().filter(course -> scoreFilter.test(course.getReviewScore(), 95)).findAny().stream()
				.forEach(System.out::println);

	}

	@Test
	public void sortCoursesBasedOnNumberOfStudentdDescending() {
		System.out.println("\n:::::::::::::: sortCoursesBasedOnNumberOfStudentdDescending ::::::::::::::");
		courses.stream().sorted(Comparator.comparing(sortStudentNumberDesc).reversed()).forEach(System.out::println);
	}

	@Test
	public void showTop3CoursesOrderedByReview() {
		System.out.println("\n:::::::::::::: showTop3CoursesOrderedByReview ::::::::::::::");
		Comparator<Course> byReviewScore = Comparator.comparing(Course::getReviewScore).reversed();
		System.out.println(courses.stream().sorted(byReviewScore).limit(3).collect(Collectors.toList()));
	}

	@Test
	public void showTop3CoursesOrderedByReviewSkip2() {
		System.out.println("\n:::::::::::::: showTop3CoursesOrderedByReviewSkip2 ::::::::::::::");
		Comparator<Course> byReviewScore = Comparator.comparing(Course::getReviewScore).reversed();
		System.out.println(courses.stream().sorted(byReviewScore).limit(3).skip(2).collect(Collectors.toList()));
	}

	@Test
	public void takeWhileRatingis95() {
		System.out.println("\n:::::::::::::: takeWhileRatingis97 ::::::::::::::");
		System.out.println(courses.stream().sorted(Comparator.comparing(Course::getReviewScore).reversed())
				.takeWhile(course -> course.getReviewScore() >= 97).collect(Collectors.toList()));
	}

	@Test
	public void skipWhileRatingis95() {
		System.out.println("\n:::::::::::::: skipWhileRatingis95 ::::::::::::::");
		System.out.println(courses.stream().sorted(Comparator.comparing(Course::getReviewScore).reversed())
				.dropWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));
	}

	@Test
	public void findCourseWithMaximumNumberOfStudents() {
		System.out.println("\n:::::::::::::: findCourseWithMaximumNumberOfStudents ::::::::::::::");
		System.out.println(courses.stream().max(Comparator.comparing(x -> x.getNoOfStudents())).get());
	}

	@Test
	public void findCourseWithMinimumNumberOfStudents() {
		System.out.println("\n:::::::::::::: findCourseWithMinimumNumberOfStudents ::::::::::::::");
		System.out.println(courses.stream().min(Comparator.comparing(x -> x.getNoOfStudents())).get());
	}

	@Test
	public void getCountOfCoursesWithAtleast95Rating() {
		System.out.println("\n:::::::::::::: getCountOfCoursesWithAtleast95Rating ::::::::::::::");
		System.out.println(courses.stream().filter(c -> c.getReviewScore() >= 95).count());
	}

	@Test
	public void getTotalNumberOfStudentsEnrolledInACourseWithAtleast95Rating() {
		System.out.println(
				"\n:::::::::::::: getTotalNumberOfStudentsEnrolledInACourseWithAtleast95Rating ::::::::::::::");
		System.out.println(
				courses.stream().filter(c -> c.getReviewScore() >= 95).mapToInt(Course::getNoOfStudents).sum());
	}

	@Test
	public void getAverageNumberOfStudentsEnrolledInACourseWithAtleast95Rating() {
		System.out.println(
				"\n:::::::::::::: getAverageNumberOfStudentsEnrolledInACourseWithAtleast95Rating ::::::::::::::");
		System.out.println(courses.stream().filter(c -> c.getReviewScore() >= 95).mapToInt(Course::getNoOfStudents)
				.average().getAsDouble());
	}

	@Test
	public void groupCoursesByCategory() {
		System.out.println("\n:::::::::::::: groupCoursesByCategory ::::::::::::::");
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
	
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,
				Collectors.maxBy(Comparator.comparing(Course::getNoOfStudents)))));
	}

}
