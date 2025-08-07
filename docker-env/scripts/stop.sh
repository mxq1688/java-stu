#!/bin/bash

# Java学习项目 - Docker环境停止脚本

echo "🛑 停止Java学习项目的开发环境..."

# 获取脚本所在目录
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

cd "$PROJECT_DIR"

# 停止所有服务
docker-compose down

echo "📊 显示容器状态..."
docker-compose ps

echo "✅ 所有服务已停止！"
echo ""
echo "🗑️  如需清理数据卷，请运行："
echo "   cd docker-env && docker-compose down -v"
echo ""
echo "🧹 如需清理所有相关容器和镜像，请运行："
echo "   cd docker-env && docker-compose down --rmi all -v --remove-orphans"