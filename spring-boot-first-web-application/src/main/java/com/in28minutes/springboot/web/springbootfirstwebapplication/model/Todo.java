package com.in28minutes.springboot.web.springbootfirstwebapplication.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {

	private int id;
	private String user;
	
	@Size(min=10, message="Add at least 10 characters")
	private String desc;
	private Date date;
	private boolean isDone;
	
	public Todo() {
		super();
	}
	
	public Todo(int id, String user, String desc, Date date, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.date = date;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", date=" + date + ", isDone=" + isDone + "]";
	}
	
	
}
