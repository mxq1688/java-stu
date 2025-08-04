package com.example.usermanager.controller;

import com.example.usermanager.model.User;
import com.example.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 * 处理HTTP请求和响应
 */
@Controller
public class UserController {
    
    // 注入用户服务
    @Autowired
    private UserService userService;
    
    /**
     * 首页 - 显示用户列表页面
     * 访问地址: http://localhost:8080/
     */
    @GetMapping("/")
    public String home(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("userCount", userService.getUserCount());
        return "index";  // 返回 templates/index.html
    }
    
    /**
     * API接口 - 获取所有用户 (返回JSON)
     * 访问地址: http://localhost:8080/api/users
     */
    @GetMapping("/api/users")
    @ResponseBody
    public List<User> getUsersApi() {
        return userService.getAllUsers();
    }
    
    /**
     * API接口 - 根据ID获取用户
     * 访问地址: http://localhost:8080/api/users/1
     */
    @GetMapping("/api/users/{id}")
    @ResponseBody
    public User getUserApi(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    /**
     * API接口 - 添加新用户
     * POST请求: http://localhost:8080/api/users
     */
    @PostMapping("/api/users")
    @ResponseBody
    public User addUserApi(@RequestBody User user) {
        return userService.addUser(user);
    }
    
    /**
     * API接口 - 删除用户
     * DELETE请求: http://localhost:8080/api/users/1
     */
    @DeleteMapping("/api/users/{id}")
    @ResponseBody
    public String deleteUserApi(@PathVariable Long id) {
        boolean success = userService.deleteUser(id);
        return success ? "删除成功" : "用户不存在";
    }
    
    /**
     * 健康检查接口
     * 访问地址: http://localhost:8080/health
     */
    @GetMapping("/health")
    @ResponseBody
    public String health() {
        return "系统运行正常！用户总数: " + userService.getUserCount();
    }
} 