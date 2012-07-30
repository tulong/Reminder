package com.wwt.reminder.logic;

import java.util.List;

import com.wwt.reminder.domain.Notifier;

import net.webservicex.Currency;

public interface CycleExchangeRateCheckTask {

	public void InfoByExchangeRateGreatThanThreshold(Currency currencyFrom,Currency currencyTo,double threshold,List<Notifier> notifiers) ;

	public void InfoByExchangeRateLowThanThreshold(Currency currencyFrom,Currency currencyTo,double threshold,List<Notifier> notifiers) ;

}
