package com.we.hibernatesessionfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	
	public void showUserList(){
		userDao.getAllUsers().forEach((x)->{
			
			System.out.printf("%d  %s %d \n",x.getId(),x.getUsername(),x.getPhoneNumber());
			
		
		});
	}
	
	public void showUserByUsername(String username){
		userDao.getUserByUserName(username).forEach((x)->{
			
			System.out.printf("%d  %s %d \n",x.getId(),x.getUsername(),x.getPhoneNumber());
			
		
		});
	}

}
