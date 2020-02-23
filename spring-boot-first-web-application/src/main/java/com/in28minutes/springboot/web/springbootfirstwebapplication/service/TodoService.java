package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	static {
		todos.add(new Todo(1, "in28minutes", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "in28minutes", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "in28minutes", "Learn Hibernate", new Date(), false));
	}
	
	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void addTodo(String user, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, user, desc, targetDate, isDone));
	}
	
	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = (Todo) iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public Todo retrieveTodo(int id) {
		for (Iterator<Todo> iterator = todos.iterator(); iterator.hasNext();) {
			Todo todo = (Todo) iterator.next();
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	
}
