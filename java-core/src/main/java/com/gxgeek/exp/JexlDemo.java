package com.gxgeek.exp;

import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.jexl3.internal.Engine;

public class JexlDemo {
    private static JexlEngine jexlEngine = new Engine();

    public static void main(String[] args) {
            JexlExpression expression = jexlEngine.createExpression("1+2+3");
            JexlContext context = new MapContext();
            Object evaluate = expression.evaluate(context);
    }

}
