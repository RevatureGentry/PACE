package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;
import com.revature.model.Todo;

public class TodoDaoTest {

	private final TodoDao dao = new TodoDaoImpl();
	
	@Test
	public void dao_ShouldReturn20Todos() {
		List<Todo> todos = dao.getAllTodos();
		
		assertEquals(20, todos.size());
		
		for (int i = 1; i < 21; i++) {
			assertEquals(i, todos.get(i-1).getId());
			assertEquals("Title: " + i, todos.get(i-1).getTitle());
			assertEquals("Body: " + i, todos.get(i-1).getBody());
		}
	}
	
	@Test
	public void dao_ShouldReturnTodoById() {
		assertTrue(dao.getTodoById(1) instanceof Todo);
	}

}
