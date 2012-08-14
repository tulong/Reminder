package com.wwt.reminder.model;

public class Informer {
	
	private String number;
	private InformerType type;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public InformerType getType() {
		return type;
	}
	public void setType(InformerType type) {
		this.type = type;
	}
	
	public void inform(String message) {
		System.out.println(type);
		System.out.println(number);
		System.out.println(message);
	}
	
}
