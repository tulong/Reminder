package com.wwt.reminder.model;

import java.util.Calendar;

public class Step {

	private Calendar timeCalendar;
	
	private String portionString;

	public Calendar getTimeCalendar() {
		return timeCalendar;
	}

	public void setTimeCalendar(Calendar timeCalendar) {
		this.timeCalendar = timeCalendar;
	}

	public String getPortionString() {
		return portionString;
	}

	public void setPortionString(String portionString) {
		this.portionString = portionString;
	}
}
