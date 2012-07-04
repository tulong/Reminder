package com.wwt.reminder.logic;

import java.util.List;

import com.wwt.reminder.model.Reminder;
import com.wwt.reminder.model.User;

public interface RemindFacade{

	public void saveUser(User user);
	
	public User findUserByName(String name);
	
	
	
	
	public void saveReminder(Reminder reminder) ;

	public List<Reminder> findReminderByUserName(String userName) ;
}