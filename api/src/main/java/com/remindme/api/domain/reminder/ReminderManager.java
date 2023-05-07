package com.remindme.api.domain.reminder;

import com.remindme.api.domain.reminder.data.ReminderGetData;
import com.remindme.api.domain.reminder.data.ReminderPostData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderManager {
    @Autowired
    private ReminderRepository repository;

    public Reminder create(ReminderPostData reminderData) {
        Reminder reminder = new Reminder(reminderData);
        repository.save(reminder);

        return reminder;
    }

    public List<ReminderGetData> list() {
        return repository.findAll().stream().map(ReminderGetData::new).toList();
    }

    public Reminder detailById(Long id) {
        return repository.getReferenceById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
