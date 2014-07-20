package com.shop.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.shop.model.Contact;
import com.shop.model.FileUploadBean;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

//	@Autowired
//	BlogInterface blogInterface;
//	
//	@Autowired
//	UserInterface userInterface;
	
//	@Autowired
//	ContactInterface contactInterface;
	
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
	@RequestMapping(value ="/cart", method=RequestMethod.GET)
	public String cart(Model model){
		model.addAttribute("location","Cart");
		return "cart";
	}
	
	@RequestMapping(value ="/review-post", method=RequestMethod.GET)
	public String review_post(Model model){
		model.addAttribute("location","Blog");
		return "review";
	}
	@RequestMapping(value ="/login", method=RequestMethod.GET)
	public String show_login(Model model){
		return "admin";
	}
	@RequestMapping(value ="/login", method=RequestMethod.POST)
	public String post_login(Model model,BindingResult result, SessionStatus status, HttpServletRequest request){
//		String user_name=request.getParameter("user_name");
//		String password=request.getParameter("password");
//		if(true){
//			model.addAttribute("user_name","asad");
//			return "admin";
//		}else{
//			return "login";
//		}
		return null;
	}
	@RequestMapping(value ="/contact", method=RequestMethod.GET)
	public String show_contact(Model model){
		Contact contact=new Contact();
		List<String> contact_subject=Arrays.asList("Delivery question","Shipping cost","Warranty","Money back");
		model.addAttribute("contact_subject",contact_subject);
		model.addAttribute("contact",contact);
		return "contact";
	}
	@RequestMapping(value ="/view-contact", method=RequestMethod.GET)
	public String view_contact_post(Model model){
//		List<Contact> list=contactInterface.getNLatestContact(10);
//		model.addAttribute("welcome_list",list);
		return "admin/view-contact";
	}
	@RequestMapping(value ="/contact", method=RequestMethod.POST)
	public String contact_submit(@ModelAttribute("contact") Contact contact,BindingResult result, SessionStatus status, HttpServletRequest request,Model model){
		if(contact !=null && (contact.getPhone().length()<=10)){
			ObjectError error=new ObjectError("contact.phone", "Wrong number");
			result.addError(error);
		}
		if(contact!=null){
			status.setComplete();
			System.out.println(contact.getFirstName());
			System.out.println(contact.getLastName());
			System.out.println(contact.getPhone());
			System.out.println(contact.getEmail());
			System.out.println(contact.getContact_subject());
			System.out.println(contact.getUser_message());
		}
		List<String> contact_subject=Arrays.asList("Delivery question","Shipping cost","Warranty","Money back");
		model.addAttribute("contact_subject",contact_subject);
		return "contact";
	}
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String formUpload(Model model){
		FileUploadBean fileUploadBean=new FileUploadBean();
		model.addAttribute("file_upload_bean",fileUploadBean);
		return "form_upload";
	}
	@SuppressWarnings("resource")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload_file(@ModelAttribute("file_upload_bean") FileUploadBean fBean,BindingResult result,HttpServletRequest request) throws IOException,FileNotFoundException{
		List<MultipartFile> files=fBean.getFiles();
		InputStream inputStream=null;
		OutputStream outputStream=null;
		if(files!=null && files.size()>0){
			for (MultipartFile multipartFile : files) {
				inputStream = multipartFile.getInputStream();
				 String rootPath = System.getProperty("catalina.home");
	                File dir = new File(rootPath + File.separator + "tmpFiles");
	                if (!dir.exists()){
	                    dir.mkdirs();}
//					File file=new File("C:/Users/F.U.C.K/Downloads/" +multipartFile.getOriginalFilename());
	                File file = new File(dir.getAbsolutePath() + File.separator + multipartFile.getOriginalFilename());
	                System.out.println(file.getAbsolutePath());
	                if(!file.exists()){
						file.createNewFile();
						outputStream = new FileOutputStream(file);
						int read=0;
						byte[] bytes=new byte[1024];
						while((read=inputStream.read(bytes))!=-1){
							outputStream.write(bytes,0,read);
						}
			    		outputStream.flush();
					}
	            inputStream.close();
			}
		}else{
			ObjectError error=new ObjectError("contact.phone", "Wrong number");
			result.addError(error);
		}
		return "form_upload";
	}
}
