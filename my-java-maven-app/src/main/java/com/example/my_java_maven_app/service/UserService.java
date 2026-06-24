package com.example.my_java_maven_app.service;

import com.example.my_java_maven_app.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public UserService() {
        // 初始化一些示例数据
        create(new User(null, "zhangsan", "zhangsan@example.com", "张三"));
        create(new User(null, "lisi", "lisi@example.com", "李四"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public List<User> findByCriteria(String username, String email) {
        return users.stream()
                .filter(user -> username == null || user.getUsername().contains(username))
                .filter(user -> email == null || user.getEmail().contains(email))
                .toList();
    }

    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public User create(User user) {
        user.setId(counter.getAndIncrement());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        users.add(user);
        return user;
    }

    public Optional<User> update(Long id, User userDetails) {
        return findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setName(userDetails.getName());
            user.setUpdatedAt(LocalDateTime.now());
            return user;
        });
    }

    public boolean delete(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
