#!/bin/bash

# Java学习项目 - Docker环境启动脚本

echo "🚀 启动Java学习项目的开发环境..."

# 获取脚本所在目录
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

cd "$PROJECT_DIR"

# 检查 Docker 是否运行
if ! docker info > /dev/null 2>&1; then
    echo "❌ Docker 未运行，请先启动 Docker"
    exit 1
fi

# 创建 .env 文件（如果不存在）
if [ ! -f .env ]; then
    echo "📝 创建 .env 文件..."
    cp env.example .env
    echo "✅ .env 文件已创建，请根据需要修改配置"
fi

echo "📦 启动开发服务 (MySQL, Redis, RabbitMQ)..."
docker-compose up -d

echo "⏳ 等待服务启动完成..."

# 等待 MySQL 启动
echo "   检查 MySQL..."
until docker-compose exec mysql mysqladmin ping -h localhost --silent 2>/dev/null; do
    echo "   MySQL 还未就绪，等待中..."
    sleep 3
done

# 等待 Redis 启动
echo "   检查 Redis..."
until docker-compose exec redis redis-cli ping 2>/dev/null | grep -q PONG; do
    echo "   Redis 还未就绪，等待中..."
    sleep 2
done

# 等待 RabbitMQ 启动
echo "   检查 RabbitMQ..."
until docker-compose exec rabbitmq rabbitmq-diagnostics ping --quiet 2>/dev/null; do
    echo "   RabbitMQ 还未就绪，等待中..."
    sleep 3
done

echo "✅ 所有服务启动完成！"
echo ""
echo "🔗 服务访问地址："
echo "   MySQL:        localhost:3306"
echo "   - 数据库:     user_manager"
echo "   - 用户名:     app_user"
echo "   - 密码:       app123"
echo ""
echo "   Redis:        localhost:6379"
echo ""
echo "   RabbitMQ:     localhost:5672"
echo "   - 管理界面:   http://localhost:15672"
echo "   - 用户名:     admin"
echo "   - 密码:       admin123"
echo ""
echo "🛑 停止服务："
echo "   cd docker-env && ./scripts/stop.sh"
echo ""
echo "📊 查看服务状态："
echo "   cd docker-env && docker-compose ps"