package com.wwt.reminder.domain;

public class CurrencyExchangeRateEvent {
	
	private CurrencyExchangeRate source;

	public CurrencyExchangeRateEvent(CurrencyExchangeRate source) {
		super();
		this.source = source;
	}

	public CurrencyExchangeRate getSource() {
		return source;
	}
	
	

}
