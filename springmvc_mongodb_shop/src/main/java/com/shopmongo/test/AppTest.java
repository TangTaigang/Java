package com.shopmongo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shopmongo.model.User;
import com.shopmongo.service.UserServiceImpl;

public class AppTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("servlet-context.xml");
		UserServiceImpl userServiceImpl= (UserServiceImpl) context.getBean("userService");
		User user=new User();
		user.setName("admin");
		user.setPassword("123456");
		userServiceImpl.createUser(user);
	}

}
