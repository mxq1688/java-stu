package com.example.my_java_maven_app.service;

import com.example.my_java_maven_app.mapper.UserMapper;
import com.example.my_java_maven_app.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public List<User> findByCriteria(String username, String email) {
        return userMapper.findByCriteria(username, email);
    }

    public Optional<User> findById(Long id) {
        return userMapper.findById(id);
    }

    public User create(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        userMapper.insert(user);
        return user;
    }

    public Optional<User> update(Long id, User userDetails) {
        return userMapper.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setName(userDetails.getName());
            user.setUpdatedAt(LocalDateTime.now());
            userMapper.update(user);
            return user;
        });
    }

    public boolean delete(Long id) {
        return userMapper.deleteById(id) > 0;
    }
}
