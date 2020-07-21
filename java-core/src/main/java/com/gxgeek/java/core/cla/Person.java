package com.gxgeek.java.core.cla;


public class Person {

    static {
        System.out.println(" 运行静态代码块1");
    }
    private static String name = staticMethod();

    static {
        System.out.println(" 运行静态代码块2");
    }

    public static String staticMethod() {
        System.out.println(" 运行静态方法");
        return null;
    }
}
