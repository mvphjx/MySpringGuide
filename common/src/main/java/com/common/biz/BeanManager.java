package com.common.biz;

import com.common.data.BeanData;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
        beanData.setList(Arrays.asList(beanNames));
        return beanData;
    }

}
