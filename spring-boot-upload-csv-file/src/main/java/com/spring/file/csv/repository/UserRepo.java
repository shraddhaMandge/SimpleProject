package com.spring.file.csv.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.file.entity.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
}
