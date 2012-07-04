package com.wwt.reminder.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.wwt.reminder.model.User;

public interface UserRepository extends CrudRepository<User, ObjectId> {
	
	public User findByName(String name);

}
