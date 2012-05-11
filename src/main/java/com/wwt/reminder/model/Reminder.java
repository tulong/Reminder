package com.wwt.reminder.model;

import java.util.Calendar;
import java.util.List;

public class Reminder {

	private Calendar startCalendar;
	private Calendar lastEditCalendar;
//	private Calendar deadlineCalendar;
	private String deadlineCalendar;
	
	public String getDeadlineCalendar() {
		return deadlineCalendar;
	}

	public void setDeadlineCalendar(String deadlineCalendar) {
		this.deadlineCalendar = deadlineCalendar;
	}

	private String task;
	
	private List<Step> steps;
	
	private List<Informer> informers;

	public Calendar getStartCalendar() {
		return startCalendar;
	}

	public void setStartCalendar(Calendar startCalendar) {
		this.startCalendar = startCalendar;
	}

	public Calendar getLastEditCalendar() {
		return lastEditCalendar;
	}

	public void setLastEditCalendar(Calendar lastEditCalendar) {
		this.lastEditCalendar = lastEditCalendar;
	}

//	public Calendar getDeadlineCalendar() {
//		return deadlineCalendar;
//	}
//
//	public void setDeadlineCalendar(Calendar deadlineCalendar) {
//		this.deadlineCalendar = deadlineCalendar;
//	}

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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder(100);
		stringBuilder.append("Deadline:"+this.deadlineCalendar+" "+this.task);
		return stringBuilder.toString();
	}
	
}
