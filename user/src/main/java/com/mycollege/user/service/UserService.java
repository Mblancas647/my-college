package com.mycollege.user.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycollege.user.exception.UserException;
import com.mycollege.user.model.User;
import com.mycollege.user.repository.UserRepository;
import com.mycollege.user.utility.HashingUtility;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void addUser(User user) throws NoSuchAlgorithmException {
		//NEED TO IMPLEMENT VALIDATION OF USER DATA and CREATION OF USER DTO OBJECT
		String password = user.getPassword();
		String uniqueSalt = HashingUtility.generateUniqueSalt();
		user.setPasswordSalt(uniqueSalt);
		String saltedPassword = uniqueSalt+password;
		String hashedPassword = HashingUtility.getHashValue(saltedPassword);
		user.setPassword(hashedPassword);
		userRepository.insert(user);
	}
	
	public User authenticateUser(String emailId, String password) throws UserException, NoSuchAlgorithmException{
		emailId = emailId.toLowerCase();
		User user = userRepository.findByEmailIncludePasswordAndSalt(emailId)
				.orElseThrow(() -> new UserException("User not found in database"));
		String hashedPasswordFromDB = user.getPassword();
		String passwordSalt = user.getPasswordSalt();
		String hashedGivenPassword = HashingUtility.getHashValue(passwordSalt+password);
		System.out.println(hashedPasswordFromDB);
		System.out.println(hashedGivenPassword);
		if(hashedPasswordFromDB.equals(hashedGivenPassword)) {
			return userRepository.findById(emailId)
					.orElseThrow(() -> new UserException("User not found in database"));
		} else {
			throw new UserException("Invalid credentials");
		}
	}
	
	public void deleteUser(String emailId) throws UserException {
		emailId = emailId.toLowerCase();
		User user = userRepository.findById(emailId)
				.orElseThrow(() -> new UserException("User not found in database"));
		userRepository.delete(user);
	}
	
	public void updateUser(User user) throws UserException {
		//NEED TO IMPLEMENT VALIDATION OF USER DATA and CREATION OF USER DTO OBJECT
		String emailId = user.getEmailId().toLowerCase();
		if(userRepository.existsById(emailId)) {
			userRepository.save(user);
		} else {
			throw new UserException("User not found in database");
		}
		
	}
}
