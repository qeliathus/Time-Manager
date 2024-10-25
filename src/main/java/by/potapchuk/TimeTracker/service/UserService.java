package by.potapchuk.TimeTracker.service;

import by.potapchuk.TimeTracker.core.entity.User;
import by.potapchuk.TimeTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        // Getting all users
        return userRepository.findAll(); // Returning all users
    }

    public User createUser(User user) {
        // Creating a new user
        return userRepository.save(user); // Saving user
    }

    public User updateUser(Long id, User user) {
        // Updating a user
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser); // Saving changes
    }

    public void deleteUser(Long id) {
        // Deleting a user
        userRepository.deleteById(id);
    }
}