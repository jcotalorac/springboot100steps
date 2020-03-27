package com.in28minutes.springboot.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRestRepository extends PagingAndSortingRepository<User, Long> {

	List<User> findByRole(String role);
}
