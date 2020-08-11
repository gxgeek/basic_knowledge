package com.gxgeek;

import java.util.LinkedList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        strToInt("42");
    }

    public static int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        long res = 0L;
        boolean flag = true;
        int index = 0;
        if (str.charAt(index) == '+') {
            index++;
            flag = true;
        } else if (str.charAt(index) == '-'){
            flag = false;
            index++;
        }
        while (index < str.length()) {
            char current = str.charAt(index);
            index++;
            if (current < '0' || current > '9') break;
            res = res * 10 + (current - '0');
            if (res > Integer.MAX_VALUE) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return flag ? (int) res : (int) -res;

    }

}
