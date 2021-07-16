package com.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 优先进行 basic认证
 */
@Configuration
@Order(1)
public class HttpBasicSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //  这个配置只针对  /actuator/** 的请求生效
        http.antMatcher("/actuator/**")
                // /actuator/下所有请求都要认证
                .authorizeRequests().anyRequest().authenticated()
                // 启用httpBasic认证模式，当springboot admin-client 配置了密码时，
                // admin-server走httpbasic的认证方式来拉取client的信息
                .and().httpBasic();
        //否则会限制 get请求
        http.csrf().disable();
    }
}
