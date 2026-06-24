package com.example.my_java_maven_app.controller;

import com.example.my_java_maven_app.model.User;
import com.example.my_java_maven_app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户管理 RESTful API
 *
 * 标准 REST 端点：
 * GET    /api/users       获取所有用户
 * GET    /api/users/{id}  获取单个用户
 * POST   /api/users       创建新用户
 * PUT    /api/users/{id}  更新用户
 * DELETE /api/users/{id}  删除用户
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取用户列表，支持按条件过滤
     * GET /api/users
     * GET /api/users?username=zhang
     * GET /api/users?email=example
     * GET /api/users?username=zhang&email=example
     */
    @GetMapping
    public ResponseEntity<List<User>> getUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email) {
        if (username != null || email != null) {
            return ResponseEntity.ok(userService.findByCriteria(username, email));
        }
        return ResponseEntity.ok(userService.findAll());
    }

    /**
     * 根据ID获取单个用户
     * GET /api/users/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * 创建新用户
     * POST /api/users
     * POST /api/users/invite/{inviteCode}
     * POST /api/users?sendWelcomeEmail=true
     * POST /api/users/invite/SUMMER2024?sendWelcomeEmail=true
     */
    @PostMapping({"", "/invite/{inviteCode}"})
    public ResponseEntity<User> createUser(
            @PathVariable(required = false) String inviteCode,
            @RequestBody User user,
            @RequestParam(required = false, defaultValue = "false") boolean sendWelcomeEmail) {
        User createdUser = userService.create(user);
        // 实际项目中：
        // 1. 根据 inviteCode 验证邀请码并处理奖励
        // 2. 根据 sendWelcomeEmail 决定是否发送邮件
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * 更新用户
     * PUT /api/users/{id}
     * PUT /api/users/{id}?notify=true
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User userDetails,
            @RequestParam(required = false, defaultValue = "true") boolean notify) {
        return userService.update(id, userDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * 删除用户
     * DELETE /api/users/{id}
     * DELETE /api/users/{id}?archive=true
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "false") boolean archive) {
        if (userService.delete(id)) {
            // 实际项目中如果 archive=true，可以归档用户而不是物理删除
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
