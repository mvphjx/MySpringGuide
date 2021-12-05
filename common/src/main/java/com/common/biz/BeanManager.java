package com.common.biz;

import com.common.data.BeanData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Spring 容器管理、封装
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 23:26
 */
@Service
@Slf4j
public class BeanManager
{
    public BeanManager()
    {
        log.info("Create BeanManager");
    }

    @Autowired
    private ApplicationContext ctx;

    public List<BeanData> get()
    {
        List<BeanData> result = new ArrayList();
        String[] beanNames = ctx.getBeanDefinitionNames();
        List<String> list = Arrays.stream(beanNames).sorted().collect(Collectors.toList());
        for (String name : list)
        {
            BeanData beanData = new BeanData();
            beanData.setName(name);
            Object bean = ctx.getBean(name);
            beanData.setClassName(bean.getClass().getName());
            result.add(beanData);
        }
        return result;
    }

}
