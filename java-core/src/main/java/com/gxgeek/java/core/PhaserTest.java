package com.gxgeek.java.core;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Phaser phaser = new Phaser();
// 1. 注册一个 party
        phaser.register();

        for (int i = 0; i < 10; i++) {

            phaser.register();

            int finalI = i;
            executorService.submit(() -> {
                // 2. 每个线程到这里进行阻塞，等待所有线程到达栅栏
                System.out.println(finalI +" :进来了");
                phaser.arriveAndAwaitAdvance();
                System.out.println(finalI +" :执行了");

                // doWork()
            });
        }
        phaser.arriveAndAwaitAdvance();
        System.out.println("finish");

    }
}
