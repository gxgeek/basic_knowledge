package com.gxgeek.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@EnableDubbo // 开启基于注解的dubbo功能
@SpringBootApplication
public class AppDubboProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(AppDubboProviderApplication.class, args);
    }
}
