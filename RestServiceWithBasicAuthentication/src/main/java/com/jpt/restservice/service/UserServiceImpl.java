package com.jpt.restservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jpt.restservice.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	private static List<User> users=new ArrayList<>();
	static{
		users.add(new User(12,"john","john",55));
		users.add(new User(14,"sam","sam",34));
		users.add(new User(16,"walker","walker",22));
		
	}
	
	
	
	public List<User> getAllUsers(){
		return users;
	}



	public Optional<User>  findById(long id) {
		return users.stream().filter(e->e.getId()==id).findFirst();
	}



	public boolean isUserExist(User user) {
		return users.stream().anyMatch(e->e.getFirstName().equals(user.getFirstName()));
	}



	public void saveUser(User user) {
		users.add(user);
		
	}



	public void updateUser(User currentUser) {
		int index = users.indexOf(currentUser);
        users.set(index, currentUser);
		
	}



	public void deleteUserById(User user) {
		users.remove(user);
		
	}

}
