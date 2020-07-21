package com.gxgeek;

import com.gxgeek.java.core.spi.SpiService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 */
public class App {
    public static int aMethod(int i) throws Exception {
        try {
            return i / 10;
        } catch (Exception ex) {
            throw new Exception("exception in a Method");
        } finally {
            System.out.printf("finally");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
//        ServiceLoader<SpiService> serviceLoader = ServiceLoader.load(SpiService.class);
//
//        Iterator<SpiService> iterator = serviceLoader.iterator();
//        while (iterator.hasNext()) {
//            SpiService spiService = iterator.next();
//
//            spiService.hello();
//        }
        int[] test = new int[5];
        for (int i = 0; i < test.length; i++) {
            test[i] = i;
        }
        getWeightIndex(test);
    }


    public static int getWeightIndex(int[] weights) {
        long[] weightByLong = new long[weights.length];

        for(int i = 0; i < weights.length; ++i) {
            weightByLong[i] = (long)weights[i];
        }

        return getWeightIndex(weightByLong);
    }

    public static int getWeightIndex(long[] weights) {
        long totalWeight = 0L;

        for(int i = 0; i < weights.length; ++i) {
            totalWeight += weights[i];
        }

        if (totalWeight <= 0L) {
            return -1;
        } else {
            long randomWeight = nextLong(1L, totalWeight);
            long curWt = 0L;

            for(int i = 0; i < weights.length; ++i) {
                curWt += weights[i];
                if (curWt >= randomWeight) {
                    return i;
                }
            }

            return -1;
        }
    }

    private static long nextLong(long start, long end) {
        if (start > end) {
            return nextLong(end, start);
        } else {
            long randVal = end - start + 1L;
            return start + ThreadLocalRandom.current().nextLong(randVal);
        }
    }

}
