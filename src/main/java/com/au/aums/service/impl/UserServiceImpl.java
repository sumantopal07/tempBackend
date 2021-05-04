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
	
	public void addUser(User user) {
		 userRepository.save(user);
		 return ;
	}

	@Override
	public Optional<User> getUser(int keyword) {
		return userRepository.findByUserId(keyword);
	}
	
}
