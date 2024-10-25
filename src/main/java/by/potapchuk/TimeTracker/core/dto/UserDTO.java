package by.potapchuk.TimeTracker.core.dto;

import by.potapchuk.TimeTracker.core.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;

}