package com.example.nacos.ctrl;

import com.alibaba.nacos.api.exception.NacosException;
import com.example.nacos.config.NacosConfig;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Log
@Controller
@RequestMapping("config")
public class ConfigController
{

    @Autowired
    private NacosConfig config;

    @RequestMapping(value = "/v", method = GET)
    @ResponseBody
    public String loginPage() throws NacosException
    {
        return config.getLoginPage();
    }

    @RequestMapping(value = "/all", method = GET)
    @ResponseBody
    public String config() throws NacosException
    {
        return config.getAllConfig();
    }

}
