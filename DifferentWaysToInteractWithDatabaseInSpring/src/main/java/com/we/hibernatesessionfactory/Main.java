package com.we.hibernatesessionfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
			ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/hibernate-sessionfactory-config.xml");
			
			UserService userService=(UserService)ctx.getBean("userService");
			userService.showUserList();
			System.out.println("================");
			userService.showUserByUsername("john");
	}
}
