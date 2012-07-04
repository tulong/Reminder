package test;

import net.webservicex.Currency;

import com.wwt.reminder.logic.CurrencyConvertor;
import com.wwt.reminder.logic.MailSender;
import com.wwt.reminder.logic.impl.CurrencyConvertorImpl;
import com.wwt.reminder.logic.impl.MailSenderImpl;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CurrencyConvertor convertor=new CurrencyConvertorImpl();
		System.out.println(convertor.conversionRate(Currency.USD, Currency.CNY));
		
		
		MailSender mailSender=new MailSenderImpl();
		mailSender.sendMail("15012817952@139.com", "TestMail", "This is a test mail ... :-)");
		
	}

}
