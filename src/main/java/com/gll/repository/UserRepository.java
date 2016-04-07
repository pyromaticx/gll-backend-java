package com.gll.repository;

import org.springframework.data.repository.CrudRepository;

import com.gll.domain.User;



public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
}
