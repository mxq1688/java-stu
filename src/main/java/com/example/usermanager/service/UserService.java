package com.example.usermanager.service;

import com.example.usermanager.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 用户业务逻辑类
 * @Service 注解表示这是一个业务逻辑组件
 */
@Service
public class UserService {
    
    // 模拟数据库，实际项目中会连接真实数据库
    private List<User> users = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong(1);
    
    // 构造函数中初始化一些测试数据
    public UserService() {
        users.add(new User(idCounter.getAndIncrement(), "张三", "zhangsan@example.com", 25));
        users.add(new User(idCounter.getAndIncrement(), "李四", "lisi@example.com", 30));
        users.add(new User(idCounter.getAndIncrement(), "王五", "wangwu@example.com", 28));
    }
    
    /**
     * 获取所有用户
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
    
    /**
     * 根据ID获取用户
     */
    public User getUserById(Long id) {
        return users.stream()
                   .filter(user -> user.getId().equals(id))
                   .findFirst()
                   .orElse(null);
    }
    
    /**
     * 添加新用户
     */
    public User addUser(User user) {
        user.setId(idCounter.getAndIncrement());
        users.add(user);
        return user;
    }
    
    /**
     * 删除用户
     */
    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
    
    /**
     * 获取用户总数
     */
    public int getUserCount() {
        return users.size();
    }
} 