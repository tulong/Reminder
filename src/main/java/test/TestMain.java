package test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

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

		MailSender mailSender=new MailSenderImpl();
		mailSender.sendMail("284134889@qq.com", "test", "test");
		
	}

}
