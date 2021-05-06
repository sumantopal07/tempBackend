package com.au.aums.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.aums.dao.UserRepository;
import com.au.aums.model.User;
import com.au.aums.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    UserRepository userRepository;

	@Override
	public Boolean checkUser(String email) {
		return (userRepository.findByEmail(email).size()==1);
	}

	@Override
	public User getUser(String email) {
		return userRepository.findByEmail(email).get(0);
	}
	
	

	
	
}
