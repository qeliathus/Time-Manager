package by.potapchuk.TimeTracker.repository;

import by.potapchuk.TimeTracker.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
