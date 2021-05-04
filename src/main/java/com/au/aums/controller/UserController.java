package com.au.aums.controller;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.aums.model.Oppurtunities;
import com.au.aums.model.User;
import com.au.aums.model.dto.UserSignupDTO;
import com.au.aums.service.UserService;


@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;

	@PostMapping(path = "/api/allowed/signup")
	public ResponseEntity<String> addUser(@RequestBody UserSignupDTO userSignupDTO) {
		
		User user = new User();
		user.setEmail(userSignupDTO.getSignupEmail());

		String password = BCrypt.hashpw(userSignupDTO.getSignupPassword(), BCrypt.gensalt());
		user.setPassword(password);
		user.setGoogleId(userSignupDTO.getSignupGoogleId());
		user.setToken(userSignupDTO.getSignupToken());

		/*
		 * if (userService.getUserByUsername(userSignupDTO.getSignupUsername()) != null)
		 * { return new ResponseEntity<>("Username already exists",
		 * HttpStatus.NOT_FOUND); }
		 * 
		 * if (userService.getUserByEmail(userSignupDTO.getSignupEmail()) != null) {
		 * return new ResponseEntity<>("email already exists", HttpStatus.NOT_FOUND); }
		 */

		userService.addUser(user);
		return new ResponseEntity<>("account created successfully", HttpStatus.OK);

	}
	@GetMapping(path = "/api/allowed/getuser/{userId}")
	public ResponseEntity<Optional<User>>  getUser(@PathVariable("userId") int userId) {
		return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);

	}
}
