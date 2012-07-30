package com.wwt.reminder.domain;

import org.springframework.beans.factory.annotation.Autowired;

import com.wwt.reminder.logic.MailSender;

public class EmailNotifier extends Notifier {
	
	@Autowired
	private MailSender mailSender;
	
	
	private String emailString;

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}



	@Override
	public void notice(String message) {
		mailSender.sendMail(emailString, "Reminder Notifier", message);
	}

}
