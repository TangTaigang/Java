package com.dominhquan.app;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dominhquan.model.Account;
import com.dominhquan.model.Item;
import com.dominhquan.service.AccountService;
import com.dominhquan.service.ItemService;
import com.dominhquan.service.MailService;
import com.dominhquan.uri.AppRestUri;


@Controller
public class RestController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	private MailService mailService;
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);

	
	@RequestMapping(value=AppRestUri.get_item,method=RequestMethod.GET)
	public @ResponseBody Item getItem(@PathVariable("id") String id){
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
	
	@RequestMapping(value=AppRestUri.check_account,method=RequestMethod.POST)
	public @ResponseBody Account checkAccount(@RequestBody Account account){
		Account check=accountService.getAccount(account.getEmail());
		if(check!=null){
			account.setEmail("fail");
		}else{
			accountService.add(account);
			mailService.sendMail("appgame.cotuong@gmail.com",account.getEmail(), "Spring Mail Subject","https://www.facebook.com/");
		}
		account.setPassword("");
		return account;
	}
	
}
