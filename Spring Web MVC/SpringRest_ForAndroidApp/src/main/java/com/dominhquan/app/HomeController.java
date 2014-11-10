package com.dominhquan.app;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.dominhquan.app.AppRestUri;
import com.dominhquan.model.Account;
import com.dominhquan.model.Item;
import com.dominhquan.service.ItemService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	ItemService itemService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value=AppRestUri.get_item,method=RequestMethod.GET)
	public @ResponseBody Item getItem(@PathVariable("id") int id){
		Item item=new Item();
		item.setId(id);
		item.setName("Chả cá");
		item.setCreateDate(new Date());
		item.setUpdateDate(new Date());
		item.setRestaurant_name("New World");
		item.setPrice(new Double("125.50"));
		logger.info("Request item "+ item.getId());
		return item;
	}
	
	@RequestMapping(value=AppRestUri.get_all_items_in_restaurant,method=RequestMethod.GET)
	public @ResponseBody List<Item> getListRestaurant(@PathVariable("name") String name){
		List<Item> list=itemService.getListItem(name);
		return list;
	}
	
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
		model.addAttribute("account",new Account());
		return "login";
	}
	@RequestMapping(value ="/", method=RequestMethod.POST)
	public String login_submit(@ModelAttribute("account") Account account,BindingResult result, SessionStatus status, HttpServletRequest request,Model model){
		if(account !=null && account.getPassword().length()<=4){
			ObjectError error=new ObjectError("account.password", "Password must be > 4 ");
			result.addError(error);
		}
//		if(contact!=null){
//			status.setComplete();
//			System.out.println(contact.getFirstName());
//			System.out.println(contact.getLastName());
//			System.out.println(contact.getPhone());
//			System.out.println(contact.getEmail());
//			System.out.println(contact.getContact_subject());
//			System.out.println(contact.getUser_message());
//			contactService.add(contact);
//		}
		model.addAttribute("location","home");
		return "index";
	}
	@RequestMapping(value ="/index", method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("location","home");
		return "index";
	}
	@RequestMapping(value ="/order", method=RequestMethod.GET)
	public String listOrder(Model model){
		model.addAttribute("location","listOrder");
		return "tables";
	}
	@RequestMapping(value ="/item", method=RequestMethod.GET)
	public String listItems(Model model){
		model.addAttribute("location","listItem");
		return "tables";
	}
}
