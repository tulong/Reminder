package com.wwt.reminder.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wwt.reminder.HomeController;
import com.wwt.reminder.model.Reminder;

@Controller
public class ReminderController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply render the view
	 */
	@RequestMapping(value = "/addRemind", method = RequestMethod.GET)
	public String showAddView(Locale locale, Model model) {
		
		return "addRemind";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/addRemind", method = RequestMethod.POST)
	public String home(String deadlineCalendar,String task) {
//		System.out.println(reminder.toString());
		System.out.println(deadlineCalendar);
		System.out.println(task);
		return "home";
	}
}
