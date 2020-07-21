package com.gxgeek.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.ServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class TestService implements CommandLineRunner {
    @Resource
    private SimpleProviderImpl simpleProvider;

    @Autowired
    private ServiceBean serviceBean;
    @Override
    public void run(String... args) throws Exception {
        log.info(simpleProvider.toString());
        log.info("{}",simpleProvider.getClass());
        log.info("{}",simpleProvider.hashCode());

        log.info(serviceBean.toString());
        log.info("{}",serviceBean.getClass());
        log.info("{}",serviceBean.hashCode());

    }
}
