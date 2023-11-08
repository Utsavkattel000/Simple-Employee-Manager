package com.example.springproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springproject.model.User;
import com.example.springproject.repository.UserRepository;
import com.example.springproject.service.UserService;

@Service
public class UserServiceIMPL implements UserService {
	@Autowired
	private UserRepository userrepo;

	@Override
	public void userSignup(User user) {
		userrepo.save(user);

	}

	@Override
	public User userLogin(String email, String psw) {

		return userrepo.findByEmailAndPassword(email, psw);
	}

}
