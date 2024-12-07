package com.demo.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = { "org.jeecg", "com.jeecg" })
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class })
public class ReportApplication
{

    public static void main(String[] args)
    {
        ConfigurableApplicationContext application = SpringApplication.run(ReportApplication.class, args);
        Environment env = application.getEnvironment();
        String port = env.getProperty("server.port");
        String path = env.containsProperty("server.servlet.context-path") ?
                env.getProperty("server.servlet.context-path") :
                "";
        System.out.print("\n----------------------------------------------------------\n\t"
                + "JimuReport 积木报表平台 is running!  Access URL:\n\t" + "报表工作台: \t\thttp://localhost:" + port
                + path + "/jmreport/list\n\t" + "仪表盘工作台: \t\thttp://localhost:" + port + path + "/drag/list\n\t"
                + "----------------------------------------------------------");
    }

}
