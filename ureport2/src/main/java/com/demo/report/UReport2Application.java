package com.demo.report;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:context.xml")
public class UReport2Application extends SpringBootServletInitializer
{

    public static void main(String[] args)
    {
        SpringApplication.run(UReport2Application.class, args);
    }

    @Bean
    public ServletRegistrationBean buildUReportServlet()
    {
        return new ServletRegistrationBean(new UReportServlet(), "/ureport/*");
    }

    //重写configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(UReport2Application.class);
    }
}
