package com.gxgeek.test;

public class Singleton {

    private volatile static com.gxgeek.test.sub.Singleton SINGLETON;


    public static com.gxgeek.test.sub.Singleton get(){
        if (SINGLETON == null){
            synchronized (com.gxgeek.test.sub.Singleton.class){
                if (SINGLETON == null){
                    SINGLETON = new com.gxgeek.test.sub.Singleton();
                }
            }
        }
        return SINGLETON;
    }
    public static com.gxgeek.test.sub.Singleton get1(){
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder{
        private static  final com.gxgeek.test.sub.Singleton singleton = new com.gxgeek.test.sub.Singleton();
    }
}
