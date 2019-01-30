package com.revature.dao;

import java.util.List;

import com.revature.model.Todo;

public interface TodoDao {

	// Read All
	List<Todo> getAllTodos();
	
	// Read one
	Todo getTodoById(int id);
	
	// Create
	Todo createTodo(Todo todo);
	
	// Update
	Todo updateTodo(Todo todo);
	
	// Delete
	Todo deleteTodo(int id);
}
