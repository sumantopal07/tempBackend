package com.au.aums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.aums.model.Oppurtunities;
import com.au.aums.model.dto.CheckUserDTO;
import com.au.aums.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	
	@Autowired
	UserService userService;

	@PostMapping(path = "/api/allowed/userExists")
	public ResponseEntity<String> checkUserExists(@RequestBody CheckUserDTO checkUserDTO) {
		
		if(userService.checkUser(checkUserDTO.getEmail())) 
				return new ResponseEntity<>("Yes User Exists", HttpStatus.OK);
		return new ResponseEntity<>("User Does'not Exist", HttpStatus.BAD_REQUEST);
	}
	
}
