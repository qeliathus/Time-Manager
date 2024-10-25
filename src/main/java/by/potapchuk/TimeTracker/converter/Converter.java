package by.potapchuk.TimeTracker.converter;

import by.potapchuk.TimeTracker.core.dto.ProjectDTO;
import by.potapchuk.TimeTracker.core.dto.RecordDTO;
import by.potapchuk.TimeTracker.core.dto.UserDTO;
import by.potapchuk.TimeTracker.core.entity.Project;
import by.potapchuk.TimeTracker.core.entity.Record;
import by.potapchuk.TimeTracker.core.entity.User;

public class Converter {

    public static UserDTO convertToDTO(User user) {
        // Converting User to UserDTO
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }

    public static ProjectDTO convertToDTO(Project project) {
        // Converting Project to ProjectDTO
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        return dto;
    }

    public static RecordDTO convertToDTO(Record record) {
        // Converting Record to RecordDTO
        RecordDTO dto = new RecordDTO();
        dto.setId(record.getId());
        dto.setStartTime(record.getStartTime());
        dto.setEndTime(record.getEndTime());
        dto.setProjectId(record.getProject().getId());
        dto.setUserId(record.getUser().getId());
        return dto;
    }
}