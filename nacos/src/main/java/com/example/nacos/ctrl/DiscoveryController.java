package com.example.nacos.ctrl;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.example.nacos.biz.NacosService;
import com.example.nacos.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("discovery")
public class DiscoveryController
{

    @Autowired
    private NacosService nacosService;
    @Autowired
    private NacosConfig config;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName) throws NacosException
    {
        return nacosService.getService(serviceName);
    }

    @RequestMapping(value = "/register", method = GET)
    @ResponseBody
    public String register(String name, String version) throws NacosException
    {
        nacosService.registerService(name, version);
        return "ok";
    }
}
