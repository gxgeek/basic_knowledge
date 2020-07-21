package com.gxgeek;

public class 第N个泰波那契数 {
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;

        while ( n-- > 0 ){
            c = a + b + c;
            b = c - a - b;
            a = c - a - b;
        }
        return a;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        int tribonacci = 第N个泰波那契数.class.newInstance().tribonacci(25);
        System.out.println(tribonacci);
    }

}
