package by.potapchuk.TimeTracker.repository;

import by.potapchuk.TimeTracker.core.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}