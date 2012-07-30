package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import net.webservicex.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.wwt.reminder.domain.EmailNotifier;
import com.wwt.reminder.domain.Notifier;
import com.wwt.reminder.logic.CurrencyConvertor;
import com.wwt.reminder.logic.CycleExchangeRateCheckTask;
@Service
public class TestTask{
	
	@Autowired
	private CurrencyConvertor convertor;

	@Scheduled(cron="*/30 */5 * ? * *")
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("test task run");

		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(simpleDateFormat.format(Calendar.getInstance().getTime()));
		System.out.println(convertor.conversionRate(Currency.USD, Currency.CNY));
		

		checkTask.InfoByExchangeRateLowThanThreshold(Currency.USD, Currency.CNY, 6.355, notifiers);
	}
	
	

	@Autowired
	private CycleExchangeRateCheckTask checkTask;
	
	private ArrayList<Notifier> notifiers;
	
	public TestTask(){
		notifiers=new ArrayList<Notifier>();
		EmailNotifier notifier=new EmailNotifier();
		notifier.setEmailString("284134889@qq.com");
		notifiers.add(notifier);
	}

}
