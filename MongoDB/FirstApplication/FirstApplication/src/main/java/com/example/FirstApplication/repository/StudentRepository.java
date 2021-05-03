package com.example.FirstApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.FirstApplication.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

	Optional<Student> findById(String id);

	void deleteById(String id); 
	

	}
