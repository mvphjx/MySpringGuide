# AdminServer
##Server
部署一个可视化的监控服务。用来显示各个客户端的情况
##Client
客户端需要增加相关配置，注册到AdminServer
####1.数据接口actuator
提供相关接口，提供监控数据（json）
####2.安全security
client需要对/actuator/**配置httpBasic认证，以便server可以访问，获取信息



