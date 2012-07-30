package com.wwt.reminder.logic.impl;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import com.wwt.reminder.logic.MailSender;

@Service
public class MailSenderImpl implements MailSender {

	@Override
	public void sendMail(String toWho, String subject, String text) {
		Email email = new SimpleEmail();
//		email.setHostName("smtp.googlemail.com");
//		email.setSmtpPort(465);
		email.setHostName("smtp.yeah.net");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("tulongwuhen", "123wwt"));
		email.setSSL(true);
		try {
			email.setFrom("tulongwuhen@yeah.net");
			email.setSubject(subject);
			email.setMsg(text);
			email.addTo(toWho);
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
