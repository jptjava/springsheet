package com.who.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Address not found") //404
public class AddressNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2744568940790986681L;
	
	
	
	public AddressNotFoundException(int id){
		super("Address not found having id "+id);
	}

}
