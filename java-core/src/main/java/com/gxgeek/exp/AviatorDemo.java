package com.gxgeek.exp;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

public class AviatorDemo {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("a", 10);
        Long result = (Long) AviatorEvaluator.execute("1+2+3 + a",map);
        System.out.println(result);
    }
}
