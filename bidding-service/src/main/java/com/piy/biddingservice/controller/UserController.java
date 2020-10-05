package com.piy.biddingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.piy.biddingservice.model.User;
import com.piy.biddingservice.service.UserService;

@RestController
public class UserController {
	@Autowired 
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@RequestMapping("/users")
	public List<User> registerUser() {
		return userService.getAllUsers();
	}
}
