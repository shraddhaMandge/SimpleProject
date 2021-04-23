package com.example.CSVFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsvFileReaderApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(CsvFileReaderApplication.class, args);

		{
			// parsing a CSV file into Scanner class constructor
			Scanner sc = new Scanner(new File("CsvFile.csv"));
			sc.useDelimiter(","); // sets the delimiter pattern
			while (sc.hasNext()) // returns a boolean value
			{
				System.out.print(sc.next()); // find and returns the next complete token from this scanner
			}
			sc.close(); // closes the scanner
		}
	}

}
