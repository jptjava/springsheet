package com.jpt.restservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;

import com.jpt.restservice.entity.User;

public interface UserService {

	
	
/*	@PreAuthorize("hasRole('USER')")*/
	public List<User> getAllUsers();



	public Optional<User>  findById(long id);

	public boolean isUserExist(User user);


	public void saveUser(User user);
	public void updateUser(User currentUser);

	public void deleteUserById(User user);

}
