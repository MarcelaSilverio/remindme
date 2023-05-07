package com.remindme.api.domain.reminder;

import com.remindme.api.domain.reminder.data.ReminderPostData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public String getStringDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd");
        return dateFormat.format(this.date);
    }
}
