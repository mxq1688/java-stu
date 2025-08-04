# Gemini CLI

本文档为设置和使用 Google Gemini CLI 提供指南。

## 概述

Gemini CLI 允许您直接从命令行与 Google 的 Gemini 模型进行交互。对于开发人员、研究人员以及任何有兴趣探索大型语言模型功能的人来说，它是一个强大的工具。

## 安装

要安装 Gemini CLI，您需要安装 Node.js 和 npm。然后，您可以使用以下命令全局安装 CLI：

```bash
npm install -g @google/gemini-cli
```

## 入门

在使用 CLI 之前，您需要使用您的 API 密钥对其进行配置。

1.  从 Google AI Studio 获取 API 密钥。
2.  运行以下命令并按照提示输入您的密钥：

    ```bash
    gemini auth
    ```

## 基本用法

您可以通过两种主要方式与 Gemini 模型进行交互：

### 1. 直接提示

您可以直接从命令行发送提示：

```bash
gemini prompt "Gemini Pro 模型的主要特点是什么？"
```

### 2. 聊天模式

要进行更具交互性的会话，您可以开始聊天：

```bash
gemini chat
```

这将打开一个聊天会话，您可以在其中与模型进行对话。

## 资源

*   **官方 GitHub 仓库:** [https://github.com/google-gemini/gemini-cli](https://github.com/google-gemini/gemini-cli)