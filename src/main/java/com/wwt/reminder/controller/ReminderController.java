package com.wwt.reminder.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jca.cci.connection.SingleConnectionFactory;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wwt.reminder.HomeController;
import com.wwt.reminder.model.Reminder;
import com.wwt.reminder.model.User;
import com.wwt.reminder.repository.ReminderRepository;
import com.wwt.reminder.repository.UserRepository;

@Controller
@SessionAttributes("currentUser")
public class ReminderController {
	
	@Autowired
	private ReminderRepository reminderRepository;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	/**
	 * Simply render the view
	 */
	@RequestMapping(value = "/remind", method = RequestMethod.GET)
	public String showAddView(@ModelAttribute("currentUser") User user,Model model) {

		List<Reminder> reminders=reminderRepository.findByUserName(user.getName());
		model.addAttribute("remindList", reminders);
		return "remind";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/remind", method = RequestMethod.POST)
	public String addRemind(@ModelAttribute("currentUser") User user, Date reminderDate,String task) throws ParseException {
//		System.out.println(reminder.toString());
		System.out.println(reminderDate);
		System.out.println(task);
		Reminder reminder=new Reminder();
//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date=simpleDateFormat.parse(deadlineCalendar+" 00:00:00");
//		reminder.setReminderDate(date);
		reminder.setTask(task);
		reminder.setUserName(user.getName());
		reminder.setReminderDate(reminderDate);
		Date currentDate=Calendar.getInstance().getTime();
		reminder.setLastEditDate(currentDate);
		reminder.setStartDate(currentDate);
		reminderRepository.save(reminder);
		
		reminder.work(user.getInformers());
		
		return "redirect:remind";
	}
	
	@RequestMapping(value = "/listRemind", method = RequestMethod.GET)
	public String showList(@ModelAttribute("currentUser") User user,Model model) {
		List<Reminder> reminders=reminderRepository.findByUserName(user.getName());
		model.addAttribute("remindList", reminders);
		return "listReminds";
	}
}
