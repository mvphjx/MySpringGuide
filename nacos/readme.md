# Getting Started

### 安装 nacos

下载程序 https://github.com/alibaba/nacos

启动服务 startup.cmd -m standalone

### 新增配置

http://127.0.0.1:8848/nacos  nacos/nacos

```
Data ID:example
Group:DEFAULT_GROUP
content:useLocalCache=true

Data ID:MySpring
Group:DEFAULT_GROUP

```



### 启动服务获取配置

- 服务配置

http://127.0.0.1/nacos/1

http://127.0.0.1/nacos/2

http://127.0.0.1/nacos/3

- 服务注册

http://127.0.0.1/nacos/discovery/register

- 服务发现

http://127.0.0.1/nacos/discovery/get?serviceName=MySpring



## 问题说明
### 版本匹配问题
- 版本 0.2.x.RELEASE 对应的是 Spring Boot 2.x 版本
- 版本 0.1.x.RELEASE 对应的是 Spring Boot 1.x 版本

#### spring-boot 2.0.9 & nacos-boot 0.2.3
- 配置读取 √
- 配置刷新 √
- 服务注册 √
- 服务发现 √

#### 官方Demo：spring-boot 2.0.3 & nacos-boot 0.2.1
- 配置读取 √
- 配置刷新 √
- 服务注册 ×  
客户端报错，但是注册成功？！
failed to req API:http://127.0.0.1:8848/nacos/v1/ns/instance. code:400 msg: caused: cluster name can only have these characters: 0-9a-zA-Z-, current: {"defaultCheckPort":80,"defaultPort":80,"healthChecker":{"type":"TCP"},"metadata":{},"name":"","useIPPort4Check":true};
- 服务发现 √

#### spring-boot 2.6.6 & nacos-boot 0.2.1
- 配置读取 √
- 配置刷新 √
- 服务注册 ×
- 服务发现 ×

#### spring-boot 2.6.6 & nacos-boot 0.2.3
- 启动报错 ClassNotFoundException：ConfigurationBeanFactoryMetadata

#### spring-boot 2.6.6 & nacos-boot 0.2.10
- 启动报错 ClassNotFoundException：ConfigurationBeanFactoryMetadata

#### spring-boot 2.0.9 & nacos-boot 0.2.10
- 配置读取 ×
- 配置刷新 ×
- 服务注册 ×
- 服务发现 ×





