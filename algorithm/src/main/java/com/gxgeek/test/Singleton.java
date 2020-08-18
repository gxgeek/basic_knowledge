package com.gxgeek.test;

import java.util.LinkedList;

public class Singleton {

    private volatile static Singleton SINGLETON;


    public static Singleton get(){
        if (SINGLETON == null){
            synchronized (Singleton.class){
                if (SINGLETON == null){
                    SINGLETON = new Singleton();
                }
            }
        }
        return SINGLETON;
    }
    public static Singleton get1(){
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder{
        private static  final Singleton singleton = new Singleton();
    }
}
