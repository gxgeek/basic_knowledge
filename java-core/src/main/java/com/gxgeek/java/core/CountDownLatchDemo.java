//package com.gxgeek.java.core;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Random;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class CountDownLatchDemo {
//
//    private static final String FORMAT = "yy-MM-dd HH:mm:ss";
//    private static final Random RANDOM = new Random();
//
//    public static String getFormat(Date date) {
//        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
//        return sdf.format(date);
//    }
//
//    public static void main(String[] args) throws Exception {
//        int selfCompleteNum = 1;
//        int allCompleteNum = 5;
//        CountDownLatch selfDownLatch = new CountDownLatch(selfCompleteNum);
//        CountDownLatch countDownLatch = new CountDownLatch(allCompleteNum);
//        //添加工人
//        Worker[] workers = new Worker[allCompleteNum];
//        for (int i = 0; i < allCompleteNum; i++) {
//            workers[i] = new Worker("emp" + i, selfDownLatch, countDownLatch);
//        }
//        //设置线程池,不适用Executors创建是为了规避资源耗尽风险
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//                .setNameFormat("worker-pool-%d").build();
//        //coolPoolSize分配
//        ExecutorService pool = new ThreadPoolExecutor(5, 20, 0L,
//                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(1024),
//                namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//        //分配线程
//        for (Worker worker : workers) {
//            pool.execute(worker);
//        }
//        //开始工作
//        selfDownLatch.countDown();
//        //完成工作
//        countDownLatch.await();
//        pool.shutdown();
//        System.out.println("均完成后的时间：" + getFormat(new Date()));
//    }
//
//    private static class Worker extends Thread {
//        private String workName;
//        private CountDownLatch selfLatch;
//        private CountDownLatch latch;
//
//        public Worker(String workName, CountDownLatch selfLatch, CountDownLatch latch) {
//            this.workName = workName;
//            this.selfLatch = selfLatch;
//            this.latch = latch;
//        }
//
//        @Override
//        public void run() {
//            System.out.println("Worker " + workName + " do work begin at " + getFormat(new Date()));
//            doWork();
//            System.out.println("Worker " + workName + " do work complete at " + getFormat(new Date()));
//        }
//
//        private void doWork() {
//            try {
//                selfLatch.await();
//                Thread.sleep(RANDOM.nextInt(3) * 1000 + 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                latch.countDown();
//                System.out.println("Worker " + workName + " CountDownLatch count " + latch.getCount());
//            }
//        }
//    }
//}