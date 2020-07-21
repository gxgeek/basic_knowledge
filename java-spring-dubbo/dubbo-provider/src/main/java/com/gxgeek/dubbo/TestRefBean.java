package com.gxgeek.dubbo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

@Data
@Slf4j
public class TestRefBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("ref  我被初始化了！！！！");
    }
}
