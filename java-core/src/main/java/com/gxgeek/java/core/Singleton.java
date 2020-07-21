package com.gxgeek.java.core;

public class Singleton {

    private String A = "abc";
    private static volatile Singleton  singleton =null;




    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    public static void main(String[] args) {

        System.out.println(Singleton.getInstance().A);

    }
}
