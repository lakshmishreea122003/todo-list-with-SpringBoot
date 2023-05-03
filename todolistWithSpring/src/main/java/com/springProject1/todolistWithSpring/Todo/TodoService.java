package com.springProject1.todolistWithSpring.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos= new ArrayList<>();
	
	private static int todocount=0;
	static {
		todos.add(new Todo(++todocount,"Lak","AWS with Lakshmi",LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todocount,"Lak","ML",LocalDate.now().plusYears(2), false));
	
	}
	
	public List<Todo> findUserByName(String name){
		Predicate<? super Todo> predicate=todo -> todo.getName().equalsIgnoreCase(name);
		return todos.stream().filter(predicate).toList();
		
	}
	
	public void addTodo(String name, String desc, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todocount,name,desc,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate=todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}

	public Todo findUserById(int id) {
		Predicate<? super Todo> predicate=todo -> todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
	
}
