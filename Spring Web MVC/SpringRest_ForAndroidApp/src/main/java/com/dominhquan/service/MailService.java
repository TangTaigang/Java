package com.dominhquan.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.dominhquan.model.Account;

public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void setVelocityEngine(VelocityEngine velocityEngine) {
	      this.velocityEngine = velocityEngine;
	}
	
	public void regAccount(Account account){
		
	}
	
	public void sendActivationEmail(final Account account,final String from){
		 MimeMessagePreparator preparator = new MimeMessagePreparator() {
	         @SuppressWarnings("unchecked")
			public void prepare(MimeMessage mimeMessage) throws Exception {
	            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	            message.setTo(account.getEmail());
	            message.setFrom(from); 
	            @SuppressWarnings("rawtypes")
				Map model = new HashMap();
	            model.put("account", account);
	            String text = VelocityEngineUtils.mergeTemplateIntoString( velocityEngine,"templates/mail.vm", "UTF-8", null);
	            message.setText(text, true);
	         }
	      };
	      this.mailSender.send(preparator);
	}
	
	public void sendMail(String from,String to,String subject,String msg){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}
	

}
