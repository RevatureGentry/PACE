package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Todo;
import com.revature.model.User;

public class DataSource {
	/**
	 * Used to simulate an RDBMS
	 */
	
	private static final DataSource instance = new DataSource();
	private final List<Todo> todos = new ArrayList<>();
	private final List<User> users = new ArrayList<>();
	
	// Restrict exterior instantiation
	private DataSource() {
		for (int i = 1; i < 21; i++) 
			todos.add(new Todo(i, "Title: " + i, "Body: " + i));
		users.add(new User("william", "Password123!", "william@test.com", "William", "Gentry"));
	}
	
	public static DataSource getInstance() {
		return instance;
	}
	
	public List<Todo> getTodoTable() {
		return todos;
	}
	
	public List<User> getUserTable() {
		return users;
	}
}
