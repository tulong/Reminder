package com.wwt.reminder.domain;

import net.webservicex.Currency;

import com.wwt.reminder.logic.CurrencyExchangeRateListener;

public class CurrencyReminder implements CurrencyExchangeRateListener {

	private Currency fromCurrency;
	private Currency toCurrency;
	private double rateThreshold;
	
	@Override
	public void updateRate(CurrencyExchangeRateEvent e) {
		// TODO Auto-generated method stub

	}

}
