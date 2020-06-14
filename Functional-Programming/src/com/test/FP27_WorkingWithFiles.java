package com.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

public class FP27_WorkingWithFiles {

	@Test
	public void test() {
		File file = new File("tempFile.txt");

		try {
			file.createNewFile();
			System.out.println("Path = " + file.getAbsolutePath());

			FileWriter writer = new FileWriter(file);
			Supplier<Stream<String>> stringSupplier = () -> Stream.of("Hi", "This is Someone else");
			stringSupplier.get().forEach(x -> {
				try {
					writer.write(x + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			writer.close();

			List<String> stringList = Files.readAllLines(Paths.get(file.getPath()));
			System.out.println(stringList);

			file = new File("tempFile2.txt");
			FileWriter writer2 = new FileWriter(file);
			stringList.stream().forEach(str -> {
				try {
					writer2.write(str + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			writer2.close();

//			file.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}