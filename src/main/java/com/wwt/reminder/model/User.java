package com.wwt.reminder.model;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private ObjectId id;
	@Indexed
	private String name;
	private String pass;
	private String email;
	private ArrayList<Informer> informers;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Informer> getInformers() {
		return informers;
	}
	public void setInformers(ArrayList<Informer> informers) {
		this.informers = informers;
	}
}
