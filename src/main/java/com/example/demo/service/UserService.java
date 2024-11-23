package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.AppUser;

public interface UserService {
    UserDto findUserByCredential(String username, String password);

    AppUser findUserById(Long id);
}
