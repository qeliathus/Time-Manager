package by.potapchuk.TimeTracker.controller;

import by.potapchuk.TimeTracker.core.entity.Record;
import by.potapchuk.TimeTracker.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/records") // Base path for managing records
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping
    public ResponseEntity<List<Record>> getAllRecords() {
        // Getting all records
        return ResponseEntity.ok(recordService.getAllRecords());
    }

    @PostMapping
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        // Creating a new record
        return ResponseEntity.ok(recordService.createRecord(record)); // Returning created record
    }
}