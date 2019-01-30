package com.revature;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.TodoService;
import com.revature.service.TodoServiceImpl;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	// Command and Mediator Design Pattern
	
	private static final TodoService todoService = new TodoServiceImpl();
	private static final UserService userService = new UserServiceImpl();
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		if (request.getRequestURI().contains("todos"))
			return todoService.process(request, response);
		else if (request.getRequestURI().contains("users"))
			return userService.process(request, response);
		else 
			return "Not yet implemented";
	}
}
