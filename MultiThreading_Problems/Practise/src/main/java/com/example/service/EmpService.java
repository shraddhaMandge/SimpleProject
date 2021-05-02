package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Employee;
import com.example.repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	EmpRepo empRepo;

	@Async
	public CompletableFuture<List<Employee>> saveEmployee(MultipartFile file) throws Exception {
		long start = System.currentTimeMillis();
		List<Employee> emp = parseCSVFile(file);
		emp = (List<Employee>) empRepo.saveAll(emp);
		long end = System.currentTimeMillis();
		return CompletableFuture.completedFuture(emp);

	}

	@Async
	public CompletableFuture<List<Employee>> findAllUsers() {
		List<Employee> users = (List<Employee>) empRepo.findAll();
		return CompletableFuture.completedFuture(users);
	}

	private List<Employee> parseCSVFile(final MultipartFile file) throws Exception {
		final List<Employee> users = new ArrayList<>();
		try {
			try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				String line;
				while ((line = br.readLine()) != null) {
					final String[] data = line.split(",");
					final Employee user = new Employee();
					user.setId(data[0]);
					user.setName(data[1]);
					user.setEmail(data[3]);
					user.setAge(data[2]);
					users.add(user);
				}
				return users;
			}
		} catch (final IOException e) {

			throw new Exception("Failed to parse CSV file {}", e);
		}
	}
}
