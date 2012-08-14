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
import com.wwt.reminder.model.Informer;
import com.wwt.reminder.model.InformerType;
import com.wwt.reminder.model.User;

@Controller
public class RegisterController {
	
	@Autowired
	private RemindFacade remindFacade;

	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String showRegisterPage() {
		return "registerPage";
	}
	
	@RequestMapping(value = "/registerPage", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute User register, HttpSession session) {
		User user=remindFacade.findUserByName(register.getName());
		if (user!=null) {
			return new ModelAndView("registerPage");
		}else {
			Informer informer=new Informer();
			informer.setNumber(user.getEmail());
			informer.setType(InformerType.EMAIL);
			user.getInformers().add(informer);
			register.setPass(DigestUtils.md5Hex(register.getPass()));
			remindFacade.saveUser(register);
			session.setAttribute("currentUser", register);
			return new ModelAndView("remind");
		}
	}
}
