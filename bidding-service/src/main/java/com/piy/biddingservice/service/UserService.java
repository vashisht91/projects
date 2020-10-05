package com.piy.biddingservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piy.biddingservice.model.User;
import com.piy.biddingservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public User getByUserId(String userId) {
		return userRepository.findById(userId).get();
	}
	
	public User getByUserIdAndPwd(String userId, String userPwd) {
		return userRepository.findByUserIdAndUserPwd(userId, userPwd);
	}
}
