package com.gxgeek.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class TestMainClass implements InitializingBean {
    private TestRefBean testRefBean;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("main 初始化 {}",testRefBean);
    }
}
