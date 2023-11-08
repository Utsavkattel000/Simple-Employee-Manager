package com.example.springproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springproject.model.User;
import com.example.springproject.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping({ "/", "/login" })
	public String getLogin() {

		return "LoginForm";
	}
   @PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {

		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User u = userService.userLogin(user.getEmail(), user.getPassword());
		if (u != null) {
			session.setAttribute("activeUser", u);
			session.setMaxInactiveInterval(200);
			model.addAttribute("fname", u.getFname());
			model.addAttribute("lname",u.getLname());
			return "Home";
		}
		model.addAttribute("message", "User Not Found");
		return "LoginForm";
	}

	@GetMapping("/signup")
	public String getSignup() {

		return "SignUpForm";
	}

	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.userSignup(user);
		return "LoginForm";
	}
	@GetMapping("/DepartmentForm")
	public String getHome() {
		
		return "DepartmentForm";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		
		return "LoginForm";
	}
	@GetMapping("/profile")
	public String profile(HttpSession session) {
		
		
		return "Profile";
	}
	@GetMapping("/Home")
	public String home() {
		
		
		return "Home";
	}
	

}