package com.dominhquan.app;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.dominhquan.model.Account;
import com.dominhquan.service.AccountService;

@Controller
public class LoginController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = {"/*","/login*"}, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("account",new Account());
		return "login";
	}
	@RequestMapping(value ={"/","/login*"}, method=RequestMethod.POST)
	public String login_submit(@ModelAttribute("account") Account account,BindingResult result,HttpSession httpSession,Model model){
		if(account !=null ){
			model.addAttribute("account",account);
			if(account.getPassword().length() <4){
				ObjectError error1=new ObjectError("account.password", "Password must be > 4 ");
				result.addError(error1);
				return "login";
			}else{
				Account result_login=accountService.getAccount(account.getEmail());
				if(result_login!=null){
					if(!passwordEncoder.matches(account.getPassword(),result_login.getPassword())){
						ObjectError error=new ObjectError("account.password", "Wrong password ! ");
						result.addError(error);
						return "login";
					}
				}else{
					ObjectError error=new ObjectError("account.email", "Email not in database ! ");
					result.addError(error);
					return "login";
				}
				account.setPassword("");
				httpSession.setAttribute("account", account);
				return "redirect:order";
			}
		}
		model.addAttribute("account",account);
		return "login";
	}
	@RequestMapping(value = {"/logout*"}, method = RequestMethod.GET)
	public String logout(Model model,SessionStatus sessionStatus,HttpSession httpSession) {
		httpSession.removeAttribute("account");
		model.addAttribute("account",new Account());
		model.addAttribute("sessionExpired","Logout successful !!!!");
		return "login";
	}
}
