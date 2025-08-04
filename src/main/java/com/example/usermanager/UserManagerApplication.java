package com.example.usermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 主启动类
 * @SpringBootApplication 包含了：
 * - @Configuration: 配置类
 * - @EnableAutoConfiguration: 启用自动配置  
 * - @ComponentScan: 组件扫描
 */
@SpringBootApplication
public class UserManagerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class, args);
        System.out.println("🚀 用户管理系统启动成功！");
        System.out.println("📱 访问地址: http://localhost:8080");
    }
} 