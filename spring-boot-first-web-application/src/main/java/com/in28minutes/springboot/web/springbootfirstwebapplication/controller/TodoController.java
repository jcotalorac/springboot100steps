package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Todo;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	TodoService todoService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("todos", todoService.retrieveTodos(name));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showaAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "Default desc", new Date(), false));
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getDate(), false);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam("id") int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam("id") int id) {
		Todo todo = todoService.retrieveTodo(id);
		// model.addAttribute("todo", todo);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUserName(model));
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	private String getLoggedInUserName(ModelMap model) {
		return (String) model.get("name");
	}
}
