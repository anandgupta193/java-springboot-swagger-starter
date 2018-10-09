package com.spring.rest.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring.rest.exception.UserNotFoundException;
import com.spring.rest.model.User;

@Service
public class UserService{
	private static List<User> userList = new ArrayList<>();
	private static final Logger LOGGER =LoggerFactory.getLogger(UserService.class);
	private static final String CLASSNAME = "UserService";
	
	
	static {
		userList.add(new User("ABCD","abcd"));
		userList.add(new User("EFGH","efgh"));
		userList.add(new User("IJKL","ijkl"));
	}
	public List<User> getAllUsers() throws UserNotFoundException{
		LOGGER.info("Inside Service::"+ CLASSNAME + " Method:: getAllUsers()" );
		List<User> resultList = new ArrayList<>();
		for(User user:userList) {
			resultList.add(user);
		}
	return resultList;
		
	}
	public User getUser(String name) throws UserNotFoundException {
		LOGGER.info("Inside Service::"+ CLASSNAME + " Method:: getUser()" );
		for(User user:userList) {
			if(user.getUserName().equals(name) ){
				
				return user;
			}
		}
		return null;
	}
	public void addUser(User b)  throws UserNotFoundException {
		userList.add(b);
	}
	public void deleteUser(String uname) {
		for(User user:userList) {
			if(user.getUserName().equals(uname) ){
				userList.remove(user);
			}
		}
	}
	
}
