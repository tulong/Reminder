package com.wwt.reminder.logic.impl;

import org.springframework.stereotype.Service;

import net.webservicex.Currency;
import net.webservicex.CurrencyConvertorSoap;

import com.wwt.reminder.logic.CurrencyConvertor;

@Service
public class CurrencyConvertorImpl implements CurrencyConvertor {

	@Override
	public double conversionRate(Currency fromCurrency, Currency toCurrency) {
		net.webservicex.CurrencyConvertor currencyConvertor=new net.webservicex.CurrencyConvertor();
		CurrencyConvertorSoap convertorSoap=currencyConvertor.getCurrencyConvertorSoap();
		return convertorSoap.conversionRate(fromCurrency, toCurrency);
	}

}
