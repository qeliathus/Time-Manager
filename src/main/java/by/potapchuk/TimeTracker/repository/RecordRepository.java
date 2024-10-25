package by.potapchuk.TimeTracker.repository;

import by.potapchuk.TimeTracker.core.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}