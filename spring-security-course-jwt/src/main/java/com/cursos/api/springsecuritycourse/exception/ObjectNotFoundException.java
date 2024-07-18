package com.cursos.api.springsecuritycourse.exception;

public class ObjectNotFoundException extends RuntimeException{

	public ObjectNotFoundException() {
	}

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}
	

}
