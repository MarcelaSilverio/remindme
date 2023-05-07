package com.remindme.api.controller;

import com.remindme.api.domain.reminder.Reminder;
import com.remindme.api.domain.reminder.ReminderManager;
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
    private ReminderManager reminderManager;

    @PostMapping
    @Transactional
    public ResponseEntity post(@RequestBody @Valid ReminderPostData reminderData, UriComponentsBuilder uriBuilder) {
        Reminder reminder = reminderManager.create(reminderData);
        URI uri = uriBuilder.path("/reminders/{id}").buildAndExpand(reminder.getId()).toUri();

        return ResponseEntity.created(uri).body(new ReminderGetData(reminder));
    }

    @GetMapping
    public ResponseEntity<List<ReminderGetData>> get() {
        return ResponseEntity.ok(reminderManager.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ReminderGetData(reminderManager.detailById(id)));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        reminderManager.delete(id);

        return ResponseEntity.noContent().build();
    }

}
