package com.gxgeek;

public class ThreadLocalTest {

    public static void main(String[] args) {
        //t1中的threadLocalHashCode变量为0x61c88647
        ThreadLocal t1 = new ThreadLocal();
//t2中的threadLocalHashCode变量为0x61c88647 + 0x61c88647
        ThreadLocal t2 = new ThreadLocal();
//t3中的threadLocalHashCode变量为0x61c88647 + 0x61c88647 + 0x61c88647
        ThreadLocal t3 = new ThreadLocal();


    }
}
