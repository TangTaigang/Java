package com.server.controller;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.model.ChatDataType;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("location","index");
		return "index";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String test(Model model) {
		model.addAttribute("location","test");
		return "test";
	}
	
//	@MessageMapping("/chat")
//	@SendTo("/data/contents")
//	public ChatDataType chat (ChatDataType chatDataType) throws Exception{
//		
//		return chatDataType;
//	}
//	
	
}
