package com.we.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
			ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/jdbctemplate-config.xml");
			
			UserService userService=(UserService)ctx.getBean("userService");
			userService.showUserList();
	}
}
