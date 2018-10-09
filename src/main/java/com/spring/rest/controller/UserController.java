package com.spring.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.exception.UserNotFoundException;
import com.spring.rest.model.User;
import com.spring.rest.service.UserService;


@RestController
public class UserController {
	private static final Logger LOGGER =LoggerFactory.getLogger(UserController.class);
	private static final String CLASSNAME = "UserController";
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/User", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOGGER.info("Inside Controller::"+ CLASSNAME + " Method:: getAllUsers()" );
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/User/{uname}", method = RequestMethod.GET)
	public User getUser(@PathVariable String uname) throws UserNotFoundException {
		LOGGER.info("Inside Controller::"+ CLASSNAME + " Method:: getUser()" );
		User user = new User();
		try {
			user=userService.getUser(uname);
		}catch(UserNotFoundException bex) {
			
		}
		return user;		
	}
	@RequestMapping(value="/User", method = RequestMethod.POST)
	public ResponseEntity <String> addUser(@RequestBody User b) {
		try {userService.addUser(b);}catch(UserNotFoundException bex) {};
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@RequestMapping(value="/User/{uname}", method = RequestMethod.DELETE)
	public ResponseEntity <String> deleteUser(@PathVariable String uname) {
		try {userService.deleteUser(uname);}catch(UserNotFoundException bex) {};
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
