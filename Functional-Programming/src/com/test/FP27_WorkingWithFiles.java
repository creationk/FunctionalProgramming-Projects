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
	List<String> stringStoreList;
	File fileOne = new File("tempFile.txt");
	File fileTwo = new File("tempFile2.txt");

	@Test
	public void testWriteAndReadAFile() {
		try {
			FileWriter writer = new FileWriter(fileOne);
			Supplier<Stream<String>> stringSupplier = () -> Stream.of("Hi", "This is Someone else");
			stringSupplier.get().forEach(x -> {
				try {
					writer.write(x + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			writer.close();

			stringStoreList = Files.readAllLines(Paths.get(fileOne.getPath()));
			System.out.println(stringStoreList);

			FileWriter writer2 = new FileWriter(fileTwo);
			stringStoreList.stream().forEach(str -> {
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