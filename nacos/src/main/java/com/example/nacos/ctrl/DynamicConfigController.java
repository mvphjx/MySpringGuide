package com.example.nacos.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自动刷新程序配置
 * 方式1 配置中心
 * 方式2 RefreshScope
 * 方式3 参考Spring源码的refresh  TODO
 */
@RestController
//@RefreshScope该注解必须标注，否则无法完成动态更新
//@RefreshScope
public class DynamicConfigController
{
    //    @Value("${config.version}")
    private String version;

    //    @Value("${config.app.name}")
    private String appName;

    //    @Value("${config.platform}")
    private String platform;

    @GetMapping("/show/version")
    public String version()
    {
        return "version=" + version + "-appName=" + appName + "-platform=" + platform;
    }
}
