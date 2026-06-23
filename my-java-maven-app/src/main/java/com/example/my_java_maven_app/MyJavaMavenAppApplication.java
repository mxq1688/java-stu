// 包声明：指定这个类所在的包路径
package com.example.my_java_maven_app;

// 导入 SpringApplication 类：用于启动 Spring Boot 应用
import org.springframework.boot.SpringApplication;
// 导入 @SpringBootApplication 注解：Spring Boot 的核心注解
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 导入 @RestController 注解：标记这是一个 REST 控制器
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// @SpringBootApplication：核心组合注解
// 包含三个功能：
// 1. @Configuration - 标记为配置类
// 2. @EnableAutoConfiguration - 启用自动配置
// 3. @ComponentScan - 自动扫描组件
@SpringBootApplication
// @RestController：REST 控制器注解
// 组合了 @Controller + @ResponseBody，返回数据直接写入 HTTP 响应
@RestController
public class MyJavaMavenAppApplication {

	// main 方法：Java 程序的标准入口点
	// args：命令行参数数组
	public static void main(String[] args) {
		// SpringApplication.run()：启动 Spring Boot 应用
		// 参数1：当前类的 Class 对象
		// 参数2：命令行参数
		// 作用：创建 Spring 上下文、启动内置服务器、自动配置 Bean
		SpringApplication.run(MyJavaMavenAppApplication.class, args);
	}

	// 简单的根路径端点
	@GetMapping("/")
	public Map<String, String> home() {
		return Map.of(
			"message", "欢迎使用 Spring Boot 应用！",
			"status", "运行正常"
		);
	}

	// 带路径变量的端点
	@GetMapping("/hello/{name}")
	public Map<String, String> hello(@PathVariable String name) {
		return Map.of(
			"greeting", "你好，" + name + "！",
			"timestamp", java.time.LocalDateTime.now().toString()
		);
	}

}
