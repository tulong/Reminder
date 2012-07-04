package com.wwt.reminder.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wwt.reminder.logic.RemindFacade;
import com.wwt.reminder.model.User;

@Controller
public class RegisterController {
	
	@Autowired
	private RemindFacade remindFacade;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute User register, HttpSession session) {
		User user=remindFacade.findUserByName(register.getName());
		if (user!=null) {
			return new ModelAndView("register");
		}else {
			register.setPass(DigestUtils.md5Hex(register.getPass()));
			remindFacade.saveUser(register);
			session.setAttribute("currentUser", register);
			return new ModelAndView("addRemind");
		}
	}
}
