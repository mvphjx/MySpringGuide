## 日志

### 架构

- 接口层：facade,例如：Slf4j

- 适配层：adapter

- 实现层：Log4j/JUL/Logback/Log4j2




### Logback

相比于Log4j，Logback提供了很多我们现在看起来理所当然的新特性：

- 支持日志文件切割滚动记录、支持异步写入
- 针对历史日志，既支持按时间或按硬盘占用自动清理，也支持自动压缩以节省硬盘空间
- 支持分支语法，通过if, then, else可以按条件配置不同的日志输出逻辑，比如判断仅在开发环境输出更详细的日志信息
  大量的日志过滤器，甚至可以做到通过登录用户Session识别每一位用户并输出独立的日志文件
- 异常堆栈支持打印jar包信息，让我们不但知道调用出自哪个文件哪一行，还可以知道这个文件来自哪个jar包

Logback主要由三部分组成（网上各种文章在介绍classic和access时都描述的语焉不详，我不得不直接翻官网文档找更明确的解释）：

- logback-core：记录/输出日志的核心实现
- logback-classic：适配层，完整实现了Slf4j接口
- logback-access：用于将Logback集成到Servlet容器（Tomcat、Jetty）中，让这些容器的HTTP访问日志也可以经由强大的Logback输出

