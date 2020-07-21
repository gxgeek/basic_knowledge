package com.gxgeek;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest1 {

    private Integer totalPrintCount = 100;
    private AtomicInteger actualPrintCount = new AtomicInteger();
    private volatile int state = 0;

    private byte[] lock = new byte[]{};
    private String groupA = "A";
    private String groupB = "B";
    private String groupC = "C";


    public static void main(String[] args) {
        new ThreadTest1().doPrint();
    }

    public void doPrint() {
        new PrintContentThread("线程" + groupA, 0, 1, groupA).start();
        new PrintContentThread("线程" + groupB, 1, 2, groupB).start();
        new PrintContentThread("线程" + groupC, 2, 0, groupC).start();
    }


    class PrintContentThread extends Thread {
        private String printContentStr;
        private Integer currentThreadPrintCount = 0;
        private Integer thisState;
        private Integer nextState;

        public PrintContentThread(String threadName, Integer thisState, Integer nextState, String printContentStr) {
            super(threadName);
            this.printContentStr = printContentStr;
            this.thisState = thisState;
            this.nextState = nextState;
        }

        @Override
        public void run() {
            try {


                synchronized (lock) {
                    while (actualPrintCount.get() < totalPrintCount) {
                        //循环检验标志位 每次都阻塞然后等待唤醒
                        while (state != thisState) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                return;
                            }
                        }
                        if (actualPrintCount.get() >= totalPrintCount){
                            return;
                        }
                        state = nextState;
                        String msg = String.format("线程:%s|content:%s| 当前线程打印次数:%s|总打印次数:%s", Thread.currentThread().getName(), printContentStr, ++currentThreadPrintCount, actualPrintCount.incrementAndGet());
                        System.out.println(msg);
                        lock.notifyAll();
//                        if (actualPrintCount.get() < totalPrintCount) {
//                            lock.wait();
//                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
