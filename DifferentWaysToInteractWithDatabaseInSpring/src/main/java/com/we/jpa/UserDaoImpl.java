package com.we.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager manager;

	
	@Override
	public List<User> getAllUsers() {
		return manager.createQuery("Select a from User a",User.class).getResultList();
	}

	@Override
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub

	}

	
}
