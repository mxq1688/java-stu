package com.example.my_java_maven_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "message", "欢迎使用 Spring Boot 应用！",
            "status", "运行正常"
        );
    }

    @GetMapping("/hello/{name}")
    public Map<String, String> hello(@PathVariable String name) {
        return Map.of(
            "greeting", "你好，" + name + "！",
            "timestamp", java.time.LocalDateTime.now().toString()
        );
    }
}
