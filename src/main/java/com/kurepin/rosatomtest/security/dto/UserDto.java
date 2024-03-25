package com.kurepin.rosatomtest.security.dto;

import com.kurepin.rosatomtest.security.models.Role;
import com.kurepin.rosatomtest.security.models.UserStatus;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private UserStatus status;
    private Long employeeId;
}
