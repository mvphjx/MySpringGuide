package com.example.nacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@NacosPropertySources({

                              /**
                               * Data ID：example 配置内容：useLocalCache=false
                               */
                              @NacosPropertySource(dataId = "example", autoRefreshed = true),
                              /**
                               * Data ID：MySpring 配置内容：Property
                               */
                              @NacosPropertySource(dataId = "MySpring", autoRefreshed = true) })
public class NacosApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(NacosApplication.class, args);
    }

    @NacosInjected
    private NamingService namingService;
    @Value("${spring.application.name}")
    private String applicationName;

    @PostConstruct
    public void registerInstance() throws NacosException
    {
        namingService.registerInstance(applicationName, "127.0.0.1", 80);
    }
}
