package com.spring.file.csv.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.spring.file.csv.repository.UserRepo;
import com.spring.file.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepo userrepo;

	String line = "";

	public void saveUserData() throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("D:\\Assignment\\spring-boot-upload-csv-file\\src\\main\\resources\\employee.csv"));

		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			User user = new User();
			user.setId(data[0]);
			user.setName(data[1]);
			user.setAge(data[2]);
			user.setEmail(data[3]);

			userrepo.save(user);

		}

	}

}