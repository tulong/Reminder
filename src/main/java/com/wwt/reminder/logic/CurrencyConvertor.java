package com.wwt.reminder.logic;

import net.webservicex.Currency;


public interface CurrencyConvertor{
	   public double conversionRate(Currency fromCurrency, Currency toCurrency);

}
