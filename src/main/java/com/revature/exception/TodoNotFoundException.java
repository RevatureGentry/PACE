package com.revature.exception;

public class TodoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TodoNotFoundException(int id) {
		super("Todo with id [" + id + "] could not be found");
	}
}
