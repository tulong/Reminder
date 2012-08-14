package com.wwt.reminder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.scheduling.commonj.TimerManagerTaskScheduler;

@Document
public class Reminder {

	@Indexed
	@Id
	private ObjectId id;
	private Date startDate;
	private Date lastEditDate;
//	private Date deadlineDate;
	private Date reminderDate;
	private String userName;

	private String task;
	
	private List<Step> steps;
	
	private List<Informer> informers;

	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the lastEditDate
	 */
	public Date getLastEditDate() {
		return lastEditDate;
	}

	/**
	 * @param lastEditDate the lastEditDate to set
	 */
	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}



	/**
	 * @return the reminderDate
	 */
	public Date getReminderDate() {
		return reminderDate;
	}

	/**
	 * @param reminderDate the reminderDate to set
	 */
	public void setReminderDate(Date reminderDate) {
		this.reminderDate = reminderDate;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public List<Informer> getInformers() {
		return informers;
	}

	public void setInformers(List<Informer> informers) {
		this.informers = informers;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder(100);
		stringBuilder.append("Deadline:"+this.reminderDate+" "+this.task);
		return stringBuilder.toString();
	}
	
	public void work(final ArrayList<Informer> informers) {
		
		
		Timer timer=new Timer("aaa");
		TimerTask timerTask=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName());
				for (Informer informer : informers) {
//					informer.inform(this.task);
				}
			}
		};
	}
	
}
