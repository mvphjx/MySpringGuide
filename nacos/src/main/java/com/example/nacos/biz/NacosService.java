package com.example.nacos.biz;

import cn.hutool.core.net.NetUtil;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.example.nacos.config.NacosConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 服务注册管理
 */
@Component
@Slf4j
public class NacosService
{

    @NacosInjected
    private NamingService namingService;
    @Autowired
    private NacosConfig config;

    /**
     * 注册服务
     *
     * @param serviceName 服务名
     * @param version     版本号
     * @throws NacosException
     */
    public void registerService(String serviceName, String version) throws NacosException
    {
        Instance instance = new Instance();
        instance.setIp(NetUtil.localIps().stream().findAny().get());
        instance.setMetadata(Collections.singletonMap("version", version)); // 设置版本信息
        namingService.registerInstance(serviceName, instance);
    }

    public List<Instance> getService(String serviceName) throws NacosException
    {
        List<Instance> allInstances = namingService.getAllInstances(serviceName);
        return allInstances;
    }

    /**
     * 启动后自动注册
     */
    @PostConstruct
    public void init()
    {
        try
        {
            registerService(config.getApplicationName(), config.getVersion());
        }
        catch (Exception e)
        {
            log.warn("NacosService.init", e);
        }
    }
}
