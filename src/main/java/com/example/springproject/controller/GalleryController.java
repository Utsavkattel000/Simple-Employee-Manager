package com.example.springproject.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
	@GetMapping("/gallery")
    public String getGallery(Model model, HttpSession session) {
		if(session.getAttribute("activeUser")==null) {
			return "loginForm";
		}
    	String[] imgNames= new File("src/main/resources/static/Photos").list();
    	model.addAttribute("imgNameList", imgNames);
    	return "Gallery";
    }
	
	
	
}
