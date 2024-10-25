package by.potapchuk.TimeTracker.controller;

import by.potapchuk.TimeTracker.converter.Converter;
import by.potapchuk.TimeTracker.core.dto.ProjectDTO;
import by.potapchuk.TimeTracker.core.entity.Project;
import by.potapchuk.TimeTracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects") // Base path for managing projects
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        // Getting all projects
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects.stream().map(Converter::convertToDTO).toList()); // Returning list of projects in DTO format
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        // Creating a new project
        Project project = projectService.createProject(projectDTO);
        return ResponseEntity.ok(Converter.convertToDTO(project)); // Returning created project
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO) {
        // Updating an existing project
        Project project = projectService.updateProject(id, projectDTO);
        return ResponseEntity.ok(Converter.convertToDTO(project)); // Returning updated project
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        // Deleting a project by ID
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build(); // Returning 204 No Content
    }
}