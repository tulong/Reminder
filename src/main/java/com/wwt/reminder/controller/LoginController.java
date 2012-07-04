package com.wwt.reminder.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wwt.reminder.model.User;
import com.wwt.reminder.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String register(String username,String password, Model model) {
		User user=userRepository.findByName(username);
		if (user==null) {
			return "register";
		}else {
			model.addAttribute("message", "Welcome "+username);
			
			return "success";
		}
	}
}
