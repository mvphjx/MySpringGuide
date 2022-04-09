package com.example.nacos.config;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Data;

@Data
public class MySpringConfigData
{
    private String LoginPage;
    private String jboss_ejb_client_prop;
}
