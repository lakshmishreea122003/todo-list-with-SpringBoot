package com.springProject1.todolistWithSpring.Todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

@Entity(name="todo-table")
public class Todo {
	
	public Todo() {
		
	}
    
	@Id
	@GeneratedValue
	private int id;
	@Column(name="name")
	private String name;
	
	@Size(min=10, message="Enter atleast 10 characters")
	private String descr;
	private LocalDate targetDate;
	private boolean done;
	
	public Todo(int id, String name, String desc, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.name = name;
		this.descr = desc;
		this.targetDate = targetDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return descr;
	}

	public void setDesc(String desc) {
		this.descr = desc;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", desc=" + descr + ", targetDate=" + targetDate + ", done=" + done
				+ "]";
	}

	
}
