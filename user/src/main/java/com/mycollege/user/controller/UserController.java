package com.mycollege.user.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycollege.user.exception.UserException;
import com.mycollege.user.model.User;
import com.mycollege.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	//NEED TO IMPLEMENT LOGGING, DTO CLASS WITH VALIDATION 
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody User user) throws NoSuchAlgorithmException{
		userService.addUser(user);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	//
	@GetMapping
	public ResponseEntity<User> authenticateUser(@RequestBody User user) throws UserException, NoSuchAlgorithmException {
		String emailId = user.getEmailId();
		String password = user.getPassword();
		User userFromDB = userService.authenticateUser(emailId, password);
		return new ResponseEntity<>(userFromDB ,HttpStatus.OK);
	}
	
	@DeleteMapping("/{emailId}")
	public ResponseEntity<String> deleteUser(@PathVariable String emailId) throws UserException{
		userService.deleteUser(emailId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<String> updateUser(@RequestBody User user) throws UserException{
		userService.updateUser(user);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
