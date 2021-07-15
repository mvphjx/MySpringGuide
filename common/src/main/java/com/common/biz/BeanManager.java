package com.common.biz;

import com.common.data.BeanData;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

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
public class BeanManager
{
    @Autowired
    private ApplicationContext ctx;

    public BeanData get()
    {
        BeanData beanData = new BeanData();
        String[] beanNames = ctx.getBeanDefinitionNames();
        List<String> list = Arrays.stream(beanNames).sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        beanData.setList(list);
        return beanData;
    }

}
