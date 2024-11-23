package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.AppUser;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDto findUserByCredential(String username, String password) {
        Optional<AppUser> appUser = userRepository.findUserByUsername(username);
        if (appUser.isPresent()) {
            AppUser user = appUser.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return UserDto.map(user);
            }
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser findUserById(Long id) {
        Optional<AppUser> user = userRepository.findById(id);
        return user.orElse(null);
    }

}
