package com.gxgeek.test;

import java.math.BigInteger;
import java.util.Scanner;

public class 卡特兰 {

    static BigInteger catalans[] = new BigInteger[101];
    static BigInteger four = new BigInteger("4");
    static BigInteger two = new BigInteger("2");
    static BigInteger one = new BigInteger("1");


    /**
     * 用于求卡特兰数
     */
    public static void prepare() {

        catalans[1] = new BigInteger("1");

        int i;
        for (i = 2; i <= 100; ++i) {
            catalans[i] = catalans[i - 1].multiply(four.multiply(BigInteger.valueOf(i)).subtract(two)).divide(BigInteger.valueOf(i + 1));
        }
    }

    public static void main(String[] args) {
        prepare();

        Scanner scanner = new Scanner(System.in);

        int t = 1;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            if (n == -1) {
                return;
            }

            //因为最后的结果应该是包含从左上角和右下角过去的两种解法.所以最后的结果需要乘以2
            System.out.println(t++ + " " + n + " " + catalans[n].multiply(two));
        }
    }
}
