package com.revature.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;
import com.revature.exception.TodoNotFoundException;
import com.revature.model.Todo;

public class TodoServiceImpl implements TodoService {
	
	private final TodoDao dao = new TodoDaoImpl();
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public Object process(HttpServletRequest request, HttpServletResponse response) {
		if (request.getMethod().equals("GET")) {
			// GET ALL LOGIC
			String[] path = request.getRequestURI().split("/");
			if (path.length == 4) {		// execute if the request is /PaceServletExamples/rest/todos
				return dao.getAllTodos();
			}
			// GET ONE LOGIC
			if (path.length == 5) {		// execute if request looks like /PaceServletExamples/rest/todos/3
				try {
					int todoId = Integer.valueOf(path[4]);
					return dao.getTodoById(todoId);
				} catch (NumberFormatException e) {
					return "Cannot convert " + path[4] + " into a number";
				} catch (TodoNotFoundException e) {
					return e.getMessage();
				}
			}
		}
		
		if (request.getMethod().equals("POST")) {
			// CREATE LOGIC
			if (request.getHeader("Content-Type").equals("application/json")) {
				try {
					Todo todo = mapper.readValue(request.getReader(), Todo.class);
					return dao.createTodo(todo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				// 415 is an Unsupported Media Type
				response.sendError(415, "Please create using application/json");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
