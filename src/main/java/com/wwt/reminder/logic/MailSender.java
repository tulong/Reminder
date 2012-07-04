package com.wwt.reminder.logic;

public interface MailSender {

	public void sendMail(String toWho,String subject,String text);
}
