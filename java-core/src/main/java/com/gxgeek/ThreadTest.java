package com.gxgeek;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private int count = 0;
    private volatile int state = 0;

    private Integer totalPrintCount = 100;
    private AtomicInteger actualPrintCount = new AtomicInteger();
    private ReentrantLock reentrantLock = new ReentrantLock();

    private final Object lock = new Object();
    private String groupA = "A";
    private String groupB = "B";
    private String groupC = "C";


    public static void main(String[] args) throws InterruptedException {
        new ThreadTest().reentLockThreadRun();
    }

    public void reentLockThreadRun() throws InterruptedException {
        Condition conditionByA = reentrantLock.newCondition();
        Condition conditionByB = reentrantLock.newCondition();
        Condition conditionByC = reentrantLock.newCondition();
        new PrintContentThread("线程:" + groupA, conditionByA, conditionByB, groupA).start();
        new PrintContentThread("线程:" + groupB, conditionByB, conditionByC, groupB).start();
        new PrintContentThread("线程:" + groupC, conditionByC, conditionByA, groupC).start();
    }

    public void turning() throws InterruptedException {
        new Thread(new TurningRunner(), "偶数").start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        new Thread(new TurningRunner(), "奇数").start();
    }

    class TurningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                // 获取锁
                synchronized (lock) {
                    // 拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    // 唤醒其他线程
                    lock.notifyAll();
                    try {
                        if (count <= 100) {
                            // 如果任务还没有结束，则让出当前的锁并休眠
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    class PrintContentThread extends Thread {
        private String printContentStr;
        private Integer currentThreadPrintCount = 0;
        private Condition thisCondition;
        private Condition nextCondition;

        public PrintContentThread(String threadName, Condition thisCondition, Condition nextCondition, String printContentStr) {
            super(threadName);
            this.printContentStr = printContentStr;
            this.thisCondition = thisCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {

                reentrantLock.lock();
                try {
                    for (int i = 0; i < totalPrintCount; i++) {
                        String msg = String.format("线程:%s|content:%s| 当前线程打印次数:%s|总打印次数:%s", Thread.currentThread().getName(), printContentStr, ++currentThreadPrintCount, totalPrintCount);
                        System.out.println(msg);
                        nextCondition.signal();
                        System.out.println("当前" + getName() + " 唤醒下一个");
                        if (i < totalPrintCount-1) {
                            System.out.println("当前" + getName() + "进入 等待");
                            thisCondition.await();
                            System.out.println("当前" + getName() + "解除 等待");
                        }
                    }
                } catch (Exception e) {
                    System.err.println(e);
                } finally {
                    reentrantLock.unlock();

                }


        }

    }
}
