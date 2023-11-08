package com.example.springproject.service;

import com.example.springproject.model.User;

public interface UserService {
	void userSignup(User user);

	User userLogin(String email, String psw);

}
