package by.potapchuk.TimeTracker.service;

import by.potapchuk.TimeTracker.core.dto.ProjectDTO;
import by.potapchuk.TimeTracker.core.entity.Project;
import by.potapchuk.TimeTracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        // Getting all projects
        return projectRepository.findAll(); // Returning all projects
    }

    public Project createProject(ProjectDTO projectDTO) {
        // Creating a new project
        Project project = new Project();
        project.setName(projectDTO.getName());
        return projectRepository.save(project); // Saving project
    }

    public Project updateProject(Long id, ProjectDTO projectDTO) {
        // Updating a project
        Project existingProject = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        existingProject.setName(projectDTO.getName());
        return projectRepository.save(existingProject); // Saving changes
    }

    public void deleteProject(Long id) {
        // Deleting a project
        projectRepository.deleteById(id);
    }
}