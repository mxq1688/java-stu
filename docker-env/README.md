# Java学习项目 - Docker开发环境

这是一个独立的Docker环境，为Java学习项目提供MySQL、Redis和RabbitMQ等基础服务。

## 🏗️ 服务架构

```
┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐
│     MySQL       │  │      Redis      │  │    RabbitMQ     │
│   (数据库)      │  │     (缓存)      │  │   (消息队列)    │
│   Port: 3306    │  │   Port: 6379    │  │   Port: 5672    │
└─────────────────┘  └─────────────────┘  └─────────────────┘
```

## 🚀 快速开始

### 1. 启动所有服务

```bash
# 进入docker环境目录
cd docker-env

# 启动服务
./scripts/start.sh
```

### 2. 停止所有服务

```bash
./scripts/stop.sh
```

### 3. 查看服务日志

```bash
# 查看所有服务日志
./scripts/logs.sh

# 查看特定服务日志
./scripts/logs.sh mysql
./scripts/logs.sh redis
./scripts/logs.sh rabbitmq
```

## 📋 服务信息

### MySQL 数据库
- **端口**: 3306
- **数据库**: user_manager
- **用户名**: app_user
- **密码**: app123
- **Root密码**: root123
- **连接URL**: `jdbc:mysql://localhost:3306/user_manager`

### Redis 缓存
- **端口**: 6379
- **数据库**: 0
- **密码**: 无

### RabbitMQ 消息队列
- **AMQP端口**: 5672
- **管理界面**: http://localhost:15672
- **用户名**: admin
- **密码**: admin123

## 📁 目录结构

```
docker-env/
├── docker-compose.yml      # Docker Compose 配置
├── env.example            # 环境变量示例文件
├── README.md              # 本文档
├── mysql/
│   └── init/
│       └── 01-init.sql    # 数据库初始化脚本
├── redis/
│   └── redis.conf         # Redis 配置文件
├── rabbitmq/              # RabbitMQ 配置目录（可扩展）
└── scripts/
    ├── start.sh           # 启动脚本
    ├── stop.sh            # 停止脚本
    └── logs.sh            # 日志查看脚本
```

## 🔧 配置说明

### 环境变量配置

第一次运行时，会自动创建 `.env` 文件。如需自定义，请复制 `env.example` 并修改：

```bash
cp env.example .env
# 然后编辑 .env 文件
```

### Java项目配置

在你的Java项目的 `application.yml` 中使用以下配置：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/user_manager?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8
    username: app_user
    password: app123
    driver-class-name: com.mysql.cj.jdbc.Driver
  
  data:
    redis:
      host: localhost
      port: 6379
      database: 0
  
  rabbitmq:
    host: localhost
    port: 5672
    username: admin
    password: admin123
```

## 🛠️ 常用命令

### 直接使用 docker-compose

```bash
# 进入docker环境目录
cd docker-env

# 启动所有服务
docker-compose up -d

# 停止所有服务
docker-compose down

# 查看服务状态
docker-compose ps

# 查看日志
docker-compose logs -f [service-name]
```

### 数据库操作

```bash
# 连接 MySQL
docker-compose exec mysql mysql -u app_user -p user_manager

# 连接 Redis
docker-compose exec redis redis-cli

# 查看 RabbitMQ 状态
docker-compose exec rabbitmq rabbitmqctl status
```

### 数据管理

```bash
# 备份 MySQL 数据
docker-compose exec mysql mysqldump -u root -p user_manager > backup.sql

# 恢复 MySQL 数据
docker-compose exec -T mysql mysql -u root -p user_manager < backup.sql
```

## 🐛 故障排除

### 1. 端口冲突

如果端口被占用，修改 `docker-compose.yml` 中的端口映射：

```yaml
ports:
  - "3307:3306"  # 将 MySQL 映射到 3307 端口
```

### 2. 数据持久化

- 数据存储在 Docker 命名卷中
- 删除容器不会丢失数据
- 完全清理数据：`docker-compose down -v`

### 3. 权限问题

```bash
chmod +x scripts/*.sh
```

### 4. 网络问题

确保 Docker 网络正常：

```bash
docker network ls
docker network inspect java-stu-network
```

## 🔗 相关资源

- [Docker Compose 文档](https://docs.docker.com/compose/)
- [MySQL Docker 镜像](https://hub.docker.com/_/mysql)
- [Redis Docker 镜像](https://hub.docker.com/_/redis)
- [RabbitMQ Docker 镜像](https://hub.docker.com/_/rabbitmq)

## 💡 使用建议

1. **开发环境**: 使用本Docker环境提供的服务
2. **测试环境**: 可以复制此目录并修改配置
3. **生产环境**: 建议使用专门的生产环境配置

---

**注意**: 这个Docker环境仅用于开发学习，不适合生产环境使用。