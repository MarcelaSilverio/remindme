package com.remindme.api.reminder;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record ReminderGetData(Long id, String name, Date date) {

    public ReminderGetData(Reminder reminder) {
        this(reminder.getId(), reminder.getName(), reminder.getDate());
    }
}
