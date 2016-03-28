package com.we.jpa;

import java.util.List;



public interface UserDao {
	
	public List<User>  getAllUsers();
	public User getUserByUserName(String username);
	public void createUser(User user);

}
