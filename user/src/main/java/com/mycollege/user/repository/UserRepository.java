package com.mycollege.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mycollege.user.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	@Query(value="{ 'emailId' : ?0 }", fields = "{ 'password' : 1, passwordSalt: 1}")
	Optional<User> findByEmailIncludePasswordAndSalt(String emailId);
}
