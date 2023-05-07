package com.remindme.api.controller;

import com.remindme.api.domain.reminder.Reminder;
import com.remindme.api.domain.reminder.data.ReminderPostData;
import com.remindme.api.domain.reminder.data.ReminderGetData;
import com.remindme.api.domain.reminder.ReminderRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("reminders")
public class ReminderController {
    @Autowired
    private ReminderRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity post(@RequestBody @Valid ReminderPostData reminderData, UriComponentsBuilder uriBuilder) {
        Reminder reminder = new Reminder(reminderData);
        repository.save(reminder);
        URI uri = uriBuilder.path("/reminders/{id}").buildAndExpand(reminder.getId()).toUri();

        return ResponseEntity.created(uri).body(new ReminderGetData(reminder));
    }

    @GetMapping
    public ResponseEntity<List<ReminderGetData>> get() {
        List<ReminderGetData> reminders = repository.findAll().stream().map(ReminderGetData::new).toList();
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Reminder reminder = repository.getReferenceById(id);

        return ResponseEntity.ok(new ReminderGetData(reminder));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
