package by.potapchuk.TimeTracker.service;

import by.potapchuk.TimeTracker.core.entity.Record;
import by.potapchuk.TimeTracker.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public List<Record> getAllRecords() {
        // Getting all records
        return recordRepository.findAll(); // Returning all records
    }

    public Record createRecord(Record record) {
        // Creating a new record
        return recordRepository.save(record); // Saving record
    }
}