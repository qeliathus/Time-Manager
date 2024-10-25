package by.potapchuk.TimeTracker.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RecordDTO {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long projectId;
    private Long userId;

}
