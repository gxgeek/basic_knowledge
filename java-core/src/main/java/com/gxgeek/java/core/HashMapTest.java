package com.gxgeek.java.core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class HashMapTest {
    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        hashMap.put("1", 1);
        HashMapThread thread0 = new HashMapThread();
        HashMapThread thread1 = new HashMapThread();
        HashMapThread thread2 = new HashMapThread();
        HashMapThread thread3 = new HashMapThread();
        HashMapThread thread4 = new HashMapThread();
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
    }
}

class HashMapThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger();
    private static Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void run() {
        while (ai.get() < 10000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }

}
