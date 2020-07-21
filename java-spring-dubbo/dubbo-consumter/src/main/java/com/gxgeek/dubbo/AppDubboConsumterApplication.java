package com.gxgeek.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@Slf4j
@EnableDubbo
@SpringBootApplication
@RestController
public class AppDubboConsumterApplication {

    @Reference()
    private SimpleProvider simpleProvider;


    public static void main(String[] args) {
        SpringApplication.run(AppDubboConsumterApplication.class, args);
    }


    @Bean
    public ApplicationRunner runner() {
        return args -> new Thread() {
            @Override
            public void run() {
                for (; ; ) {

                    try {

                        log.info(simpleProvider.getSimpleInfoName(new Result(), "qweqwe").toString());
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
        }.start();

    }


    @GetMapping("/test")
    public String test() {
        simpleProvider.getSimpleInfo();
        return "success";
    }
}
