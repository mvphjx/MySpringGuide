# MySpringGuide
基于Spring框架进行框架、中间件集成


## 集成与管理
### Spring
Spring的核心是提供了一个容器（container），通常称为Spring应用上下文（Spring application context），它们会创建和管理应用组件。
### SptingBoot
Spring Boot是Spring框架的扩展，提供了很多增强生产效率的方法。理念是约定优于配置，例如：自动配置（autoconfiguration）
### Spring Cloud
一套微服务解决方案，可以用来开发云原生应用
### Spring Integration和Spring Batch
Spring Integration解决了实时集成问题。
Spring Batch解决的则是批处理集成的问题
## WEB
### SpringMVC
Spring的Web框架，编写控制器类以处理Web请求
### Spring WebFlux
新响应式Web框架，响应式编程模型
## 持久化
### SpringData
持久化框架，将应用程序的数据repository定义为简单的Java接口，在定义驱动存储和检索数据的方法时使用一种命名约定即可。
### Hibernate
依据JPA规范，实现的全自动持久化框架
### Mybatis
半自动持久化框架，核心是xml的sql语句
### Mybatis-Plus
Mybatis增强版，简单的增删改查，自动生成SQL
## 权限
### Spring Security
Spring Security解决了应用程序通用的安全性需求，包括身份验证、授权和API安全性。
## 微服务
### Nacos
服务注册中心、配置中心
