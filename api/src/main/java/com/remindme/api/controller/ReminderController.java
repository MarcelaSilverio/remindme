package com.remindme.api.controller;

import com.remindme.api.reminder.Reminder;
import com.remindme.api.reminder.ReminderPostData;
import com.remindme.api.reminder.ReminderGetData;
import com.remindme.api.reminder.ReminderRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reminders")
public class ReminderController {
    @Autowired
    private ReminderRepository repository;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid ReminderPostData reminder) {
        repository.save(new Reminder(reminder));
    }
    @GetMapping
    public List<ReminderGetData> get() {
        return repository.findAll().stream().map(ReminderGetData::new).toList();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
