package com.gxgeek.test;

import java.util.concurrent.atomic.AtomicInteger;

public class 多线程交替打出ABC {

    private static volatile int STATE = 0;
    private static Object lock = new Object();
    private static Integer limit = 100;
    private static AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {
       new PrintThread("A",0,1).start();
       new PrintThread("B",1,2).start();
       new PrintThread("C",2,0).start();
    }


    private static class PrintThread  extends Thread{
//        private String threadName;
        private String printCountent;
        private Integer thisState;
        private Integer nextState;

        public PrintThread(String printCountent,Integer thisState,Integer nextState){
            super();
            this.printCountent = printCountent;
            this.thisState = thisState;
            this.nextState = nextState;
        }


        @Override
        public void run() {
            synchronized (lock){
                while (atomicInteger.get()   < limit){
                    while (STATE!= thisState){
                        try {
                            if (atomicInteger.get() >= limit){
                                lock.notifyAll();
                                return;
                            }
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    if (atomicInteger.get() >= limit){
                        lock.notifyAll();
                        return;
                    }
                    atomicInteger.incrementAndGet();
                    System.out.println(printCountent);
                    STATE = nextState;
                    lock.notifyAll();
                }

            }


        }
    }
}
