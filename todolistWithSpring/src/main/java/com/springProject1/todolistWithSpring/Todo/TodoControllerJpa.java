package com.springProject1.todolistWithSpring.Todo;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	private TodoService todoService;
	private TodoRepository todoRepo;
	
	public TodoControllerJpa(TodoService todoService,TodoRepository todoRepo) {
		super();
		this.todoService = todoService;
		this.todoRepo=todoRepo;
	}



	@RequestMapping("listTodo")
	public String listAll(ModelMap model) {
		String name=getloggedIn(model);
		List<Todo> todos=todoRepo.findByName(name);
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model){
		String name=getloggedIn(model);
		Todo todo= new Todo(4,name,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String showTodoPage(ModelMap model, @Valid Todo todo, BindingResult result){
		if(result.hasErrors()) {
			return "todo";
		}
		String name=getloggedIn(model);
//		String name= (String)model.get("name");
		todoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:listTodo";
	}



	private String getloggedIn(ModelMap model) {//ModelMap model
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:listTodo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String updateTodo(@RequestParam int id, ModelMap model) {
		Todo todo=todoService.findUserById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodoPage(ModelMap model, @Valid Todo todo, BindingResult result){
		if(result.hasErrors()) {
			return "todo";
		}
		String name=getloggedIn(model);
		todo.setName(name);
		todoService.updateTodo(todo);
		return "redirect:listTodo";
	}
	
	
}

