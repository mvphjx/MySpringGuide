package com.demo.mybatisplus.config;

import cn.hutool.db.dialect.impl.MysqlDialect;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/18 13:46
 */
@Configuration
@MapperScan("com.demo.mybatisplus.mapper")
public class MybatisPlusConfig
{
    /**
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor()
    {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 自定义ID生成器
     *
     * @return
     */
    @Bean
    public MybatisPlusPropertiesCustomizer plusPropertiesCustomizer()
    {
        return plusProperties -> plusProperties.getGlobalConfig()
                .setIdentifierGenerator(new DefaultIdentifierGenerator());
    }

    @Bean
    public DefaultSqlInjector sqlInjector(){
        return new MySqlInjector();
    }

}
