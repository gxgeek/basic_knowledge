package com.gxgeek;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Component("gxgeekk")
public class ServiceA implements SmartInstantiationAwareBeanPostProcessor {
    @Autowired
    private ServiceB serviceB;

    public void dot(){
        System.out.println("sac");
    }
}
