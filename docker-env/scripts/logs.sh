#!/bin/bash

# Java学习项目 - 查看Docker服务日志脚本

# 获取脚本所在目录
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

cd "$PROJECT_DIR"

if [ $# -eq 0 ]; then
    echo "📋 显示所有服务日志..."
    docker-compose logs -f
elif [ "$1" = "mysql" ]; then
    echo "📋 显示 MySQL 日志..."
    docker-compose logs -f mysql
elif [ "$1" = "redis" ]; then
    echo "📋 显示 Redis 日志..."
    docker-compose logs -f redis
elif [ "$1" = "rabbitmq" ]; then
    echo "📋 显示 RabbitMQ 日志..."
    docker-compose logs -f rabbitmq
else
    echo "用法: $0 [mysql|redis|rabbitmq]"
    echo "不指定服务名则显示所有日志"
fi