package com.we.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void showUserList(){
		userDao.getAllUsers().forEach((x)->{
			
			System.out.printf("%d  %s %d \n",x.getId(),x.getUsername(),x.getPhoneNumber());
			
		
		});
	}

}
