package com.spring.file.csv.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.file.csv.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "userData")
	public void setDataInDB() throws IOException {
		service.saveUserData();

	}

}
