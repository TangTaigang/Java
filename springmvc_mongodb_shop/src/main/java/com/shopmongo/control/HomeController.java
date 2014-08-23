package com.shopmongo.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopmongo.model.User;
import com.shopmongo.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "index.jsp";
	}
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String createUser(@ModelAttribute User user,Model model) {
		userService.createUser(user);
		return "index.jsp";
	}
}
