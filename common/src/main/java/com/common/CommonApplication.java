package com.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author han
 * 必须要配置 org.jeecg.modules.jmreport  不然有些组件扫描不进来？？  ,"org.jeecg.modules.jmreport"
 *
 */
@SpringBootApplication(scanBasePackages = {"com.common","org.jeecg.modules.jmreport"})
public class CommonApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(CommonApplication.class, args);
    }

}
