package com.wwt.reminder.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.wwt.reminder.logic.CurrencyConvertor;
import com.wwt.reminder.logic.CurrencyExchangeRateListener;

import net.webservicex.Currency;

public class CurrencyExchangeRate {
	
	protected Currency fromCurrency;
	protected Currency toCurrency;
	protected double rate;

	@Autowired
	private CurrencyConvertor convertor;
	
	private Set<CurrencyExchangeRateListener> listeners;
	
	public CurrencyExchangeRate(Currency fromCurrency, Currency toCurrency) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		listeners=new HashSet<CurrencyExchangeRateListener>();
	}
	
	public void addListener(CurrencyExchangeRateListener listener) {
		listeners.add(listener);
	}

	public void removeListener(CurrencyExchangeRateListener listener) {
		listeners.remove(listener);
	}
	
	public void updateRate() {
		this.rate=convertor.conversionRate(fromCurrency, toCurrency);
		CurrencyExchangeRateEvent event=new CurrencyExchangeRateEvent(this);
		for (CurrencyExchangeRateListener listener : listeners) {
			listener.updateRate(event);
		}
		
	}
}
