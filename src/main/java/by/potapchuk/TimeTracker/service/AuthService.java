package by.potapchuk.TimeTracker.service;

import by.potapchuk.TimeTracker.core.dto.UserDTO;
import by.potapchuk.TimeTracker.core.entity.User;
import by.potapchuk.TimeTracker.repository.UserRepository;
import by.potapchuk.TimeTracker.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(UserDTO userDTO) {
        // Registering a new user
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Encrypting password
        user.setRole(userDTO.getRole());
        return userRepository.save(user); // Saving user to the database
    }

    public String login(String username, String password) {
        // Logging in the user and generating JWT token
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtUtil.generateToken(username);
    }
}