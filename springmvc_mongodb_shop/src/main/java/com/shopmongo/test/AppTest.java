package com.shopmongo.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shopmongo.model.User;
import com.shopmongo.service.UserServiceImpl;

public class AppTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("servlet-context.xml");
		UserServiceImpl userServiceImpl= (UserServiceImpl) context.getBean("userService");
		
		// Create user
		User user=new User();
		user.setName("admin");
		user.setPassword("123456");
//		userServiceImpl.createUser(user);
		
		
		// Update user
		
	
		
		// Delete user 
		
		
		// Find user
		User user_find=userServiceImpl.getUserInfo("admin");
		System.out.println(user_find.toString());
		
		List<User> data_find=userServiceImpl.searchUserByCondition("ad");
		for (User entry : data_find) {
			System.out.println(entry.toString());
		}
		
		// Login
		System.out.println(userServiceImpl.checkLoggin("admin", "123456"));
	}

}
