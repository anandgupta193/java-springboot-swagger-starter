package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
