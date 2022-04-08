package com.example.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}
