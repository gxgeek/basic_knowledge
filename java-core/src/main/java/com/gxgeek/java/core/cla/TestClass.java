package com.gxgeek.java.core.cla;

public class TestClass {


    public static void main(String[] args) throws ClassNotFoundException {


        Class.forName("com.gxgeek.java.core.cla.Person");
        System.out.println("---------------------------");
        ClassLoader.getSystemClassLoader().loadClass("com.gxgeek.java.core.cla.User");
    }
}
