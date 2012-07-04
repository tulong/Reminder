package com.wwt.reminder.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.wwt.reminder.model.Reminder;

public interface ReminderRepository extends CrudRepository<Reminder, ObjectId> {

	public List<Reminder> findByUserName(String userName) ;
}
