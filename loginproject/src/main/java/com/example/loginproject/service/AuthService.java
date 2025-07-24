package com.example.loginproject.service;

import com.example.loginproject.model.User;
import com.example.loginproject.repository.UserRepository;
import com.example.loginproject.util.SHA256Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public void register(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        String hashed = SHA256Util.encode(password);
        userRepository.save(new User(username, hashed));
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) return false;
        return user.getPassword().equals(SHA256Util.encode(password));
    }
}
