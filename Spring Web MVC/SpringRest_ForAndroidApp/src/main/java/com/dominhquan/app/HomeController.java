package com.dominhquan.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dominhquan.app.AppRestUri;
import com.dominhquan.model.Item;
import com.dominhquan.service.ItemService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	@Autowired
//	ItemService itemService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value=AppRestUri.get_item,method=RequestMethod.GET)
	public @ResponseBody Item getItem(@PathVariable("id") int id){
		Item item=new Item();
		item.setId(id);
		logger.info("Request item "+ item.getId());
		return item;
	}
//	@RequestMapping(value=AppRestUri.get_item,method=RequestMethod.GET)
//	public @ResponseBody List<Item> getListRestaurant(){
//		List<>
//		return item;
//	}
	@RequestMapping(value=AppRestUri.order_menu,method=RequestMethod.POST)
	public @ResponseBody Item orderItem(@RequestBody Item item){
		logger.info("New order : " + item.getId());
		item.setCreateDate(new Date());
		item.setUpdateDate(new Date());
		return item;
	}
	
	/*
	 *  Admin view
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("location","home");
		return "index";
	}
	@RequestMapping(value ="/index", method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("location","home");
		return "index";
	}
}
