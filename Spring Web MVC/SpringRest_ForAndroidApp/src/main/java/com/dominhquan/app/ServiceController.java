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

	@RequestMapping(value ="/order", method=RequestMethod.GET)
	public String listOrder(Model model,HttpSession httpSession){
		Account account= ((httpSession.getAttribute("account")!=null) ? (Account) httpSession.getAttribute("account")  :new Account());
		if(account.getEmail()!=null){
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
	@RequestMapping(value ="/item**", method=RequestMethod.GET)
	public String listItems(Model model){
		model.addAttribute("location","listItem");
		return "tables";
	}
}
 