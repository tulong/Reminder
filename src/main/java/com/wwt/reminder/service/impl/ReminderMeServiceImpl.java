package com.wwt.reminder.service.impl;

import java.util.ArrayList;
import java.util.Calendar;

import net.webservicex.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.wwt.reminder.domain.CurrencyExchangeRate;
import com.wwt.reminder.domain.EmailNotifier;
import com.wwt.reminder.domain.Notifier;
import com.wwt.reminder.logic.CurrencyConvertor;
import com.wwt.reminder.logic.CycleExchangeRateCheckTask;

public class ReminderMeServiceImpl {

	@Autowired
	private CycleExchangeRateCheckTask checkTask;
	
	private ArrayList<Notifier> notifiers;
	
	public ReminderMeServiceImpl(){
		notifiers=new ArrayList<Notifier>();
		EmailNotifier notifier=new EmailNotifier();
		notifier.setEmailString("284134889@qq.com");
		notifiers.add(notifier);
	}
	

	@Scheduled(cron="0 */20 * ? * *")
	public void notice() {
		CurrencyExchangeRate usd2cnyCurrencyExchangeRate=new CurrencyExchangeRate(Currency.USD, Currency.CNY);
		
		
		
		checkTask.InfoByExchangeRateLowThanThreshold(Currency.USD, Currency.CNY, 6.355, notifiers);
	}
}
