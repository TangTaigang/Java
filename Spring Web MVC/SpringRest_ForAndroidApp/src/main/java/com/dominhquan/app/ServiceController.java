package com.dominhquan.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class ServiceController {

	@RequestMapping(value ="/order", method=RequestMethod.GET)
	public String listOrder(Model model){
		model.addAttribute("location","listOrder");
		return "tables";
	}
	@RequestMapping(value ="/item**", method=RequestMethod.GET)
	public String listItems(Model model){
		model.addAttribute("location","listItem");
		return "tables";
	}
}
