package com.kurepin.rosatomtest.security.services;


import com.kurepin.rosatomtest.security.dto.UserDto;
import com.kurepin.rosatomtest.security.models.User;

import java.text.ParseException;

public interface UserService {
    UserDto saveUser(User user);
    void deleteUserById(Long id);
    UserDto updateUser(User user) throws ParseException;
    UserDto getUserById(Long id) throws ParseException;
}
