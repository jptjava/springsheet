package com.we.springdatajpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
			ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/spring-data-jpa-config.xml");
			
			UserService userService=(UserService)ctx.getBean("userService");
			userService.showUserList();
			System.out.println("=================");
			userService.showUserByUserName("john");
	}
}
