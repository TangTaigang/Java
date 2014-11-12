package com.dominhquan.app;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dominhquan.model.Account;

@Controller
@SessionAttributes("account")
public class ServiceController {

	@RequestMapping(value ="/order*", method=RequestMethod.GET)
	public String listOrder(Model model,HttpSession httpSession){
		if(validateSession(httpSession)){
			Account account=(Account) httpSession.getAttribute("account");
			System.out.println("-----------------------------");
			System.out.println(account.getEmail());
			System.out.println(account.getPassword());
			System.out.println("-----------------------------");
			return "tables";
		}
		model.addAttribute("sessionExpired","User session expired please login again !!!!");
		model.addAttribute("account",new Account());
		return "login";
	}
	
	@RequestMapping(value ="/item*", method=RequestMethod.GET)
	public String listItems(Model model){
		model.addAttribute("location","listItem");
		return "tables";
	}
	
	@RequestMapping(value ="/dashboard*", method=RequestMethod.GET)
	public String dashboard(Model model,HttpSession httpSession){
		if(validateSession(httpSession)){
			Account account=(Account) httpSession.getAttribute("account");
			System.out.println("-----------------------------");
			System.out.println(account.getEmail());
			System.out.println(account.getPassword());
			System.out.println("-----------------------------");
			return "index";
		}
		model.addAttribute("sessionExpired","User session expired please login again !!!!");
		model.addAttribute("account",new Account());
		return "login";
	}
	
	public boolean validateSession(HttpSession httpSession){
		Account account= ((httpSession.getAttribute("account")!=null) ? (Account) httpSession.getAttribute("account")  :new Account());
		if(account.getEmail()==null || account.getEmail().equalsIgnoreCase("")){
			return false;
		}
		return true;
	}
}
 