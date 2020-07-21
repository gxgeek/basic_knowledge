package com.gxgeek.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service
public class SimpleProviderImpl implements SimpleProvider{


    @Override
    public Result getSimpleInfo() {
        System.out.println("run with zhe method");
        return new Result();
    }

    @Override
    public String getSimpleInfoName(String name) {
        log.info("{}", name);
        return "success";
    }

    @Override
    public String getSimpleInfoName(Result result, String name) {
        log.info("{}|{}",result, name);

        return "success";
    }

    @Override
    public String getSimpleInfo(String name, String method) {
        log.info("{}|{}",name,method);
        return "success";
    }

}
