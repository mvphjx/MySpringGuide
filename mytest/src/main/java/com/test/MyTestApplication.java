package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTestApplication
{
    public static void main(String[] args)
    {
        System.out.println("=====Application启动=====");
        SpringApplication.run(MyTestApplication.class, args);
        System.out.println("=====Application启动完成=====");
    }

}
