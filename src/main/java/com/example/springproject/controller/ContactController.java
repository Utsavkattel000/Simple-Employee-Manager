package com.example.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springproject.utils.MailUtils;

@Controller
public class ContactController {
	@Autowired
	private MailUtils mailUtils;
	
	
	@GetMapping("/contact")
    public String getContact() {
       
    	
    	return "ContactForm";
    }
	@PostMapping("/contact")
	public String postContact(@RequestParam String email, @RequestParam String subject, @RequestParam String message) {
		mailUtils.sendEmail(email,subject,message);
		
		
		return "ContactForm";
	}
	
	
}
