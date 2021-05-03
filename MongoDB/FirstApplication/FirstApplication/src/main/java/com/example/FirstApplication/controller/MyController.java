package com.example.FirstApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstApplication.entity.Student;
import com.example.FirstApplication.repository.StudentRepository;

@RestController
public class MyController {

	@Autowired
	public StudentRepository studentrepository;

	@GetMapping("getStudent")
	public List<Student> getStudent() {
		return studentrepository.findAll();
	}

	@PostMapping("addStudent")
	public String addStudent(@RequestBody Student student) {
        Student inserted = studentrepository.insert(student);
		studentrepository.save(student);
		return "student created" + inserted.getName();
	}

	@GetMapping("getStudent/id")
	public Optional<Student> getStudentBOptionalyId(@PathVariable String id) {
		return studentrepository.findById(id);
	}

	@DeleteMapping("deleteStudent")
	public String deleteStudent(@PathVariable String id) {
		studentrepository.deleteById(id);
		return "deleted Sucessufully";
	}
	
	@GetMapping("test")
	public String Test() {
		return "Hello";
		
	}

}
