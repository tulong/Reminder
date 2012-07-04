package com.wwt.reminder.logic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wwt.reminder.logic.RemindFacade;
import com.wwt.reminder.model.Reminder;
import com.wwt.reminder.model.User;
import com.wwt.reminder.repository.ReminderRepository;
import com.wwt.reminder.repository.UserRepository;

public class RemindFacadeImpl implements RemindFacade {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReminderRepository reminderRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User findUserByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public void saveReminder(Reminder reminder) {
		reminderRepository.save(reminder);

	}

	@Override
	public List<Reminder> findReminderByUserName(String userName) {
		return reminderRepository.findByUserName(userName);
	}

}
