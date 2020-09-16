package com.gxgeek.test.sub;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    private static volatile int state = 0;
    private static int total = 100;
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static Object lock = new Object();

    public static void main(String[] args) {
        new PrintThread("A",0,1).start();
        new PrintThread("B",1,2).start();
        new PrintThread("C",2,0).start();
    }
    static class PrintThread extends Thread {
        private String print;
        private Integer thisState;
        private Integer nextState;

        public PrintThread(String print, int curState, int nextState) {
            this.print = print;
            this.thisState = curState;
            this.nextState = nextState;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    while (atomicInteger.get() < total) {
                        while (state != thisState) {
                            if (atomicInteger.get() >= total) {
                                lock.notifyAll();
                                break;
                            }
                            lock.wait();
                        }
                        if (atomicInteger.get() >= total) {
                            lock.notifyAll();
                            break;
                        }
                        System.out.println("---" + print);
                        state = nextState;
                        atomicInteger.incrementAndGet();
                        lock.notifyAll();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
