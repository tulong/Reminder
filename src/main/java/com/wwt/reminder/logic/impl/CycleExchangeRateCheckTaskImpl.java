package com.wwt.reminder.logic.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.webservicex.Currency;

import com.wwt.reminder.domain.Notifier;
import com.wwt.reminder.logic.CurrencyConvertor;
import com.wwt.reminder.logic.CycleExchangeRateCheckTask;

@Service
public class CycleExchangeRateCheckTaskImpl implements
		CycleExchangeRateCheckTask {

	@Autowired
	private CurrencyConvertor convertor;

	@Override
	public void InfoByExchangeRateGreatThanThreshold(Currency currencyFrom,
			Currency currencyTo, double threshold, List<Notifier> notifiers) {
		double rate=convertor.conversionRate(currencyFrom, currencyTo);
		String messageString="1 " +currencyFrom+" exchange "+rate+" "+currencyTo+" is great than your threshold:"+threshold;
		if (rate>=threshold) {
			for (Iterator<Notifier> iterator = notifiers.iterator(); iterator.hasNext();) {
				Notifier notifier = (Notifier) iterator.next();
				notifier.notice(messageString);
			}
		}
		
	}

	@Override
	public void InfoByExchangeRateLowThanThreshold(Currency currencyFrom,
			Currency currencyTo, double threshold, List<Notifier> notifiers) {
		double rate=convertor.conversionRate(currencyFrom, currencyTo);
		String messageString="1 " +currencyFrom+" exchange "+rate+" "+currencyTo+" is low than your threshold:"+threshold;
		if (convertor.conversionRate(currencyFrom, currencyTo)<=threshold) {
			for (Iterator<Notifier> iterator = notifiers.iterator(); iterator.hasNext();) {
				Notifier notifier = (Notifier) iterator.next();
				notifier.notice(messageString);
			}
		}
		
	}

}
