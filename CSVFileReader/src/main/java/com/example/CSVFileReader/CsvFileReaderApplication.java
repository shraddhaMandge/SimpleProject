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
			
			Scanner sc = new Scanner(new File("CsvFile.csv"));
			sc.useDelimiter(",");
			while (sc.hasNext()) 
			{
				System.out.print(sc.next()); 
			}
			sc.close(); 
		}
	}

}
