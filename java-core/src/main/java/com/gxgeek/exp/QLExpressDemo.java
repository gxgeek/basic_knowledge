package com.gxgeek.exp;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

import java.util.HashMap;
import java.util.Map;

public class QLExpressDemo {
    public static void main(String[] args) throws Exception {
        ExpressRunner runner = new ExpressRunner();
        String express = "1+2*3+a";
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();

        context.put("a", 10);
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);

    }
}
