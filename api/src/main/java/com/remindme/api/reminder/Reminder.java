package com.remindme.api.reminder;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "reminders")
@Entity(name = "Reminder")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reminder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date date;

    public Reminder(ReminderPostData reminder) {
        this.name = reminder.name();
        this.date = reminder.date();
    }
}
