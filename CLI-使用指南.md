# Spring Boot CLI 速查

## 安装
```bash
brew tap spring-io/tap
brew install spring-boot
spring --version
```

## 创建项目

```bash
# Java + Maven（默认）
spring init --dependencies=web my-app

# Java + Gradle
spring init --dependencies=web --type=gradle-project my-app

# Java + Gradle (Kotlin DSL)
spring init --dependencies=web --type=gradle-project-kotlin my-app

# Kotlin + Gradle
spring init --dependencies=web --language=kotlin --type=gradle-project-kotlin my-app
```

## 常用依赖

`web`, `data-jpa`, `mysql`, `h2`, `lombok`, `security`, `devtools`

```bash
# 查看所有依赖
spring init --list
```

## 运行项目

**Maven:**
```bash
mvn spring-boot:run
mvn clean package
```

**Gradle:**
```bash
./gradlew bootRun
./gradlew build
```

## 帮助
```bash
spring help init
spring init --list
```
