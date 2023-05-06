package com.remindme.api.reminder;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record ReminderPostData(
        @NotBlank
        String name,
        @DateTimeFormat
        @Future
        @NotNull
        Date date) {

        public ReminderPostData(Reminder reminder) {
                this(reminder.getName(), reminder.getDate());
        }
}
