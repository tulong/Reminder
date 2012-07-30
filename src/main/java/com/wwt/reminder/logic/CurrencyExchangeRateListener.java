package com.wwt.reminder.logic;

import com.wwt.reminder.domain.CurrencyExchangeRateEvent;

public interface CurrencyExchangeRateListener {
	
	public void updateRate(CurrencyExchangeRateEvent e) ;

}
