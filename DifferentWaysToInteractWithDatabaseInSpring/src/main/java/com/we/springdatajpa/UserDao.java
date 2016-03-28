package com.we.springdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	
	public List<User>  findAll();
	
	public List<User> findByUsername(String username);
	

}
