package com.wwt.reminder.service.impl;

import java.util.ArrayList;

import net.webservicex.Currency;

import org.springframework.scheduling.annotation.Scheduled;

import com.wwt.reminder.domain.CurrencyExchangeRate;
import com.wwt.reminder.domain.EmailNotifier;
import com.wwt.reminder.domain.Notifier;

public class ReminderUsd2Cny {
	
	private CurrencyExchangeRate usd2cnyCurrencyExchangeRate;
	
	private ArrayList<Notifier> notifiers;
	
	public ReminderUsd2Cny(){
		notifiers=new ArrayList<Notifier>();
		EmailNotifier notifier=new EmailNotifier();
		notifier.setEmailString("15012817952@139.com");
		notifiers.add(notifier);
		usd2cnyCurrencyExchangeRate=new CurrencyExchangeRate(Currency.USD, Currency.CNY);
	}

	@Scheduled(cron="0 */20 * ? * *")
	public void notice() {
		usd2cnyCurrencyExchangeRate.updateRate();
	}
}
