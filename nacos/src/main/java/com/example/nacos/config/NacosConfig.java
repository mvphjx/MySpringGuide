package com.example.nacos.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置管理
 * 1. @NacosValue 从配置中心获取
 * 2. @Value进行简单属性注入、
 * 3. @ConfigurationProperties进行批量绑定
 * 4. 通过注入Environment接口实现灵活的属性获取
 */
@Component
@Data
@NacosPropertySources({ @NacosPropertySource(dataId = "MySpring", autoRefreshed = true) })
public class NacosConfig
{
    @NacosInjected
    private ConfigService configService;
    @NacosValue(value = "${LoginPage}", autoRefreshed = true)
    private String loginPage;
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${nacos.config.group}")
    private String group;
    @Value(value = "${app.version}")
    private String version;
    @Value(value = "${app.build.time}")
    private String buildTime;

    public String getAllConfig() throws NacosException
    {
        String config = configService.getConfig(applicationName, group, 3000L);
        return config;
    }

}
