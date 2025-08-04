# 🚀 Spring Boot 用户管理系统

一个简单的Spring Boot学习项目，展示了Spring Boot + Spring MVC的基本用法。

## 📋 项目功能

- ✅ 用户列表展示
- ✅ REST API接口
- ✅ 热重载开发
- ✅ JSON数据交互
- ✅ 模板页面渲染

## 🛠️ 技术栈

- **Java 17+**
- **Spring Boot 3.2.1**
- **Spring MVC**
- **Thymeleaf** (模板引擎)
- **Maven** (项目管理)

## 📁 项目结构

```
java-stu/
├── pom.xml                                          # Maven配置文件
├── src/main/java/com/example/usermanager/
│   ├── UserManagerApplication.java                 # 🚀 启动类
│   ├── controller/
│   │   └── UserController.java                    # 🎛️ 控制器层
│   ├── service/
│   │   └── UserService.java                       # 💼 业务逻辑层
│   └── model/
│       └── User.java                              # 📦 数据模型
├── src/main/resources/
│   ├── application.yml                             # ⚙️ 配置文件
│   └── templates/
│       └── index.html                             # 🎨 页面模板
└── README.md                                       # 📖 项目说明
```

## 🚀 快速启动

### 1. 确保环境
```bash
java -version    # 需要Java 17+
mvn -version     # 需要Maven 3.6+
```

### 2. 启动项目
```bash
# 方式1: 使用Maven直接运行
mvn spring-boot:run

# 方式2: 先编译再运行
mvn clean package
java -jar target/user-manager-1.0.0.jar
```

### 3. 访问应用
- **主页**: http://localhost:8080
- **API接口**: http://localhost:8080/api/users
- **健康检查**: http://localhost:8080/health

## 🔗 API接口列表

| 方法 | 路径 | 说明 | 示例 |
|------|------|------|------|
| GET | `/` | 主页 | 用户列表页面 |
| GET | `/api/users` | 获取所有用户 | JSON格式用户列表 |
| GET | `/api/users/{id}` | 获取指定用户 | 获取用户1: `/api/users/1` |
| POST | `/api/users` | 添加新用户 | JSON格式提交用户数据 |
| DELETE | `/api/users/{id}` | 删除用户 | 删除用户1: `/api/users/1` |
| GET | `/health` | 健康检查 | 系统状态信息 |

## 📚 学习要点

### Spring Boot核心注解
- `@SpringBootApplication` - 主启动类，包含自动配置
- `@Controller` - 控制器，处理HTTP请求
- `@Service` - 业务逻辑组件
- `@GetMapping` - GET请求映射
- `@PostMapping` - POST请求映射
- `@ResponseBody` - 返回JSON数据

### 核心概念
1. **依赖注入**: 使用`@Autowired`自动注入依赖
2. **MVC模式**: Model-View-Controller分层架构
3. **REST API**: 符合RESTful规范的接口设计
4. **模板引擎**: 使用Thymeleaf渲染动态页面
5. **自动配置**: Spring Boot的约定优于配置原则

## 🧪 测试API接口

### 使用浏览器测试GET请求
```
http://localhost:8080/api/users          # 获取所有用户
http://localhost:8080/api/users/1        # 获取用户1
http://localhost:8080/health             # 健康检查
```

### 使用curl测试POST请求
```bash
# 添加新用户
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"新用户","email":"new@example.com","age":25}'

# 删除用户
curl -X DELETE http://localhost:8080/api/users/1
```

## 💡 开发技巧

### 热重载
项目启用了Spring Boot DevTools，修改代码后自动重启：
- 修改Java代码 → 自动重启应用
- 修改模板文件 → 立即生效
- 修改配置文件 → 自动重启应用

### 日志查看
应用启动后可以看到详细日志：
```
🚀 用户管理系统启动成功！
📱 访问地址: http://localhost:8080
```

## 🎯 下一步学习

完成这个项目后，你可以继续学习：

1. **数据持久化** 📊
   - 集成Spring Data JPA
   - 连接MySQL/PostgreSQL数据库
   - 数据库迁移和版本管理

2. **安全认证** 🔐
   - Spring Security集成
   - JWT Token认证
   - 用户权限管理

3. **单元测试** ✅
   - JUnit 5测试框架
   - MockMvc Web层测试
   - 集成测试

4. **部署运维** 🚀
   - Docker容器化
   - 云服务器部署
   - 监控和日志管理

## ❓ 常见问题

### Q: 启动时报端口被占用？
A: 修改`application.yml`中的`server.port`为其他端口

### Q: 页面显示不正常？
A: 检查Thymeleaf模板语法，确保`th:`属性正确

### Q: API返回404？
A: 检查控制器的`@RequestMapping`路径是否正确

## 🤝 学习交流

这是一个基础的学习项目，适合Spring Boot初学者。通过这个项目，你将掌握：
- Spring Boot项目搭建
- MVC架构设计
- REST API开发
- 前后端数据交互

**Happy Coding! 🎉** 