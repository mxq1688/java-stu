
npm install -g run-deepseek-cli

可选模型：

    deepseek-chat（默认模型，适合自然语言聊天）

    deepseek-coder-6.7b-instruct（适合代码任务）

    deepseek-coder-1.3b-instruct（轻量模型）

    deepseek-coder-33b-instruct（最大模型，可能需要官方支持）

设置模型
    方法1
    deepseek-cli -m deepseek-coder-6.7b-instruct
    方法2
    export DEEPSEEK_MODEL=deepseek-coder-6.7b-instruct
    方法3：
        用户主目录
        .deepseek-cli.json
            {
                "model": "deepseek-coder-6.7b-instruct",
                "temperature": 0.1,
                "maxTokens": 2048,
                "includeSystemPrompt": true,
                "autoSave": true,
                "outputFormat": "markdown"
            }

deepseek-cli