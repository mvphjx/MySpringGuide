package com.common.config;

import com.common.base.result.ResponseResult;
import com.common.biz.UserBiz;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.session.ConcurrentSessionFilter;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Spring Security配置
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/14 22:39
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserBiz userBiz;

    /**
     * 密码加密器
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    /**
     * 用户登录鉴权 关联数据库
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userBiz);
    }

    /**
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/"
     * 退出登录的地址为 "/logout"，退出成功后返回json
     * 系统监控 /actuator/** 交由basic认证,这里不拦截
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests().antMatchers("/login", "/logout","/actuator/**","/report/**","/v2/**","/swagger-resources","/css/**","/fonts/**","/image/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin().loginPage("/login").defaultSuccessUrl("/").and().logout()
                .logoutSuccessHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(ResponseResult.ok("注销成功!")));
                    out.flush();
                    out.close();
                });
        //否则会限制 get请求logout
        http.csrf().disable();
        http.addFilterAt(new ConcurrentSessionFilter(sessionRegistry(), event -> {
            HttpServletResponse resp = event.getResponse();
            resp.setContentType("application/json;charset=utf-8");
            resp.setStatus(401);
            PrintWriter out = resp.getWriter();
            out.write(new ObjectMapper().writeValueAsString(ResponseResult.failed("您已在另一台设备登录，本次登录已下线!")));
            out.flush();
            out.close();
        }), ConcurrentSessionFilter.class);
    }

    /**
     * session管理
     *
     * @return
     */
    @Bean
    SessionRegistryImpl sessionRegistry()
    {
        return new SessionRegistryImpl();
    }

}
