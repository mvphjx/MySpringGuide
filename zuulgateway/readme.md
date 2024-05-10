# 简易网关

## 配置

- 系统配置
  application.properties
- 简单路由配置
  application.properties的
- 数据库路由配置
  gateway_api_define

## 自定义扩展

### 管理功能
- 配置查看
- 配置刷新


### ZuulFilter
ZuulFilter 是 Spring Cloud Zuul 中用于处理请求的过滤器，它在微服务架构中扮演着重要的角色，负责请求的路由、拦截、认证等。
- filterType(): 返回过滤器的类型，如 "pre"、"route"、"post"、"error" 等。
- filterOrder(): 返回一个整数值来指定过滤器的执行顺序，数字越小执行越早。
- shouldFilter(): 返回一个布尔值，判断该过滤器是否执行。
- run(): 实现过滤器的具体逻辑

## 使用

- 原始地址：http://localhost:8081/gt/header
- 代理后地址：http://localhost:8082/header
- 代理扩展：新增header信息






