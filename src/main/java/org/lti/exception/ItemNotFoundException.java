package org.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException(String msg) {
		super(msg);
		
	}

	
	
	
}
