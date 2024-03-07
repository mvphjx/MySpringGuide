# nacos 配置中心&注册中心示例 

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



### 配置读取

- 服务配置

http://127.0.0.1/nacos/config/v

### 服务注册

- 服务注册

http://127.0.0.1/nacos/discovery/register?name=demo&version=0.0.2

- 服务发现

http://127.0.0.1/nacos/discovery/get?serviceName=nacos

### 监控

- metrics数据

    需要修改nacos服务器\conf\application.properties，开启endpoints

http://127.0.0.1:8848/nacos/actuator/prometheus

- prometheus

http://localhost:9090/service-discovery


prometheus.yml
```
scrape_configs:
  - job_name: "prometheus"
    metrics_path: "/nacos/actuator/prometheus"
    static_configs:
      - targets: ["localhost:8848"]
```
- grafana

http://localhost:3000/




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





