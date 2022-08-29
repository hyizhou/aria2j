### 介绍

Aria2远程调用的java封装。

各方法功能以及使用请查看：[官方文档](https://aria2.github.io/manual/en/html/aria2c.html)

### 前提

需要安装Aria2并开启其远程调用功能

### 待完成

- WebSocket方式的远程调用


### 使用方式
主要是通过`Aria2jInit`生成远程调用接口对象，而后通过该对象进行操作。
```text
// 初始化对象
Aria2 aria2 = Aria2jInit.init(url);
// 使用aria2进行远程调用
aria2.addUri(null, link);
```

