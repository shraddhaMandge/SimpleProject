package com.example.CsvFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsvFileReaderApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(CsvFileReaderApplication.class, args);

		BufferedReader bufferReader = new BufferedReader(new FileReader("Employee.csv"));
		{
			String Line = "";
			try {
				while ((Line = bufferReader.readLine()) != null) {
					String[] value = Line.split(",");
					System.out.println("id = " + value[0] + " " + "Name = " + value[1] + " " + "Email = " + value[2]
							+ " " + "age = " + value[3] + " " + " gender = " + value[4]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
