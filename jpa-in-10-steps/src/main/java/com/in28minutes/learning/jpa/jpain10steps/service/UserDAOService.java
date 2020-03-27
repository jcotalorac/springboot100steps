package com.in28minutes.learning.jpa.jpain10steps.service;

import javax.persistence.EntityManager;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;

public class UserDAOService {

	private EntityManager entityManager;

	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}
}
