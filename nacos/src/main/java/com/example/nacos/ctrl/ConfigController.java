package com.example.nacos.ctrl;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Log
@Controller
@RequestMapping("")
public class ConfigController
{

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @RequestMapping(value = "/1", method = GET)
    @ResponseBody
    public boolean get()
    {
        return useLocalCache;
    }

    @NacosValue(value = "${LoginPage}", autoRefreshed = true)
    private String loginPage;

    @RequestMapping(value = "/2", method = GET)
    @ResponseBody
    public String loginPage() throws NacosException
    {
        return loginPage;
    }

    @NacosInjected
    private ConfigService configService;

    @RequestMapping(value = "/3", method = GET)
    @ResponseBody
    public String config() throws NacosException
    {
        String config = configService.getConfig("MySpring", "DEFAULT_GROUP", 3000);
        return config;
    }

    @RequestMapping(value = "/4", method = GET)
    @ResponseBody
    public String listener() throws NacosException
    {
        configService.addListener("MySpring", "DEFAULT_GROUP", new AbstractListener()
        {
            @Override
            public void receiveConfigInfo(String configInfo)
            {
                log.warning(configInfo);
            }
        });
        return "ok,开启配置监听";
    }
}
