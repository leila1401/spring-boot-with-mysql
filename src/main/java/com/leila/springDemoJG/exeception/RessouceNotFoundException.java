package com.leila.springDemoJG.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessouceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RessouceNotFoundException(String message) {
		super(message);
	}
	

}
