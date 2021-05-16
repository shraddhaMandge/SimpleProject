package com.spring.file.csv.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import  org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.file.csv.repository.UserRepo;
import com.spring.file.entity.User;


@Service
public class UserService {
	public static final Logger logger=LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepo userrepo;

	String line = "";

	public void saveUserData() throws IOException {
		  logger.info("***** Started saving the data *****");
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
			  logger.info("*****  database updated *****");
			
		  

		}

	}

}