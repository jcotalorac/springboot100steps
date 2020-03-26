package com.in28minutes.springboot.jpa;

public class User {

	private Long id;
	private String name;
	private String role;

	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

}
