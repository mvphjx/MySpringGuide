# Getting Started

## Project Structure 项目结构
    src 项目源码
        |___main 源码
            |___java java源码
                |___ctrl 前端请求层
                |___data vo对象
                |___biz 业务层
                |___dao 数据持久层
                |___model 持久化对象
                |___config 框架配置
                |___common/base 公共层
                    |___constansts 常量
                    |___covert 对象转化器
                    |___enums 枚举
                    |___utils 工具类
            |___resources 资源文件
                |___application Spring配置文件
        |___test 模拟数据，便于调试
            |___java 单元测试

[Java应用结构规范](!https://developer.aliyun.com/article/876318)        
        
### 业务概述
- 用户角色管理（springdata）
- 商品管理（mybatis-plus）

#### spring-boot-starter-actuator
- 可以配合Idea Endpoints-Health/Mappings使用

- 接口访问 http://localhost/actuator

- 集成admin http://localhost:8769

#### springdata
    关联关系维护：
    查询，注解配置即可
    新增/更新，需要结合业务决定是否维护引用的实体。

### 在线文档
#### 特性
- 代码即文档，自动生成接口文档
- 在线&离线文档
- 在线测试
- 根据项目配置，定制文档
#### 访问地址
- springfox-swagger-ui
http://localhost/swagger-ui.html#/
- swagger-bootstrap-ui 
http://localhost/doc.html


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.2/maven-plugin/reference/html/#build-image)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-security)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-amqp)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-kafka)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#using-boot-devtools)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-spring-mvc-template-engines)

### Guides
The following guides illustrate how to use some features concretely:

* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)





