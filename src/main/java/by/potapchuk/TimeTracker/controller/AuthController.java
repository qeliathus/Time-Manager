package by.potapchuk.TimeTracker.controller;

import by.potapchuk.TimeTracker.converter.Converter;
import by.potapchuk.TimeTracker.core.dto.UserDTO;
import by.potapchuk.TimeTracker.core.entity.User;
import by.potapchuk.TimeTracker.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth") // Base path for authentication
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        // Registering a new user
        User user = authService.register(userDTO);
        return ResponseEntity.ok(Converter.convertToDTO(user)); // Returning user in DTO format
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Logging in the user
        return ResponseEntity.ok(authService.login(username, password)); // Returning JWT token
    }
}