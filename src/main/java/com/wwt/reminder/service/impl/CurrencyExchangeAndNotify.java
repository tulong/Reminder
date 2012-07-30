package com.wwt.reminder.service.impl;

import java.util.Map;
import java.util.Set;

import com.wwt.reminder.domain.CurrencyExchangeRate;

public class CurrencyExchangeAndNotify {
	
	private Map<String, CurrencyExchangeRate> map;
	
	public void registCurrencyExchange(String key,CurrencyExchangeRate currencyExchangeRate) {
		map.put(key, currencyExchangeRate);
	}
	
	public void unregist(String key) {
		map.remove(key);
	}
	
	public void work() {
		Set<String> set=map.keySet();
		for (String key : set) {
			CurrencyExchangeRate currencyExchangeRate=map.get(key);
			currencyExchangeRate.updateRate();
		}
	}

}
