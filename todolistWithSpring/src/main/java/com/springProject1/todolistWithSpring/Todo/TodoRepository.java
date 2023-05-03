package com.springProject1.todolistWithSpring.Todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	public List<Todo> findByName(String name);
}
