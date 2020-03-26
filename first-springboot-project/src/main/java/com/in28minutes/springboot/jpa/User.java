package com.in28minutes.springboot.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
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
