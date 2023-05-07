package com.remindme.api.domain.reminder.data;

import com.remindme.api.domain.reminder.Reminder;

import java.util.Date;

public record ReminderGetData(Long id, String name, String date) {

    public ReminderGetData(Reminder reminder) {
        this(reminder.getId(), reminder.getName(), reminder.getStringDate());
    }
}
