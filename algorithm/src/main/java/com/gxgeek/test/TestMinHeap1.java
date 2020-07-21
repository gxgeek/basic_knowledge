package com.gxgeek.test;

import java.util.HashMap;
import java.util.LinkedList;

public class TestMinHeap1 {

    private int[] table = new int[16];


    private int size;

    public void push(int e) {
        table[size++] = e;
        fixUP();

    }

    private void fixUP() {
        int k = size - 1;
        int f;
        while ((f = ((k - 1) / 2)) > 0) {
//            Comparable fVal = (Comparable)table[f];
//            Comparable kVal = (Comparable)  table[k];
            if (table[f] <= table[k]) {
                break;
            }
//            if (fVal.compareTo(kVal) <= 0){
//                break;
//            }
            int jVal = table[k];
//            int i = table[f];
            table[k] = table[f];
            table[f] = jVal;
            k = f;
        }
    }

    public Object pop() {
        if (size == 0) {
            throw new RuntimeException("无子元素");
        }
        Object popVal = table[0];
        table[0] = table[--size];
        table[size] = 0;
        fixDown();
        return popVal;
    }


    private void fixDown() {
        int f = 0;
        int k;
        while ((k = (2 * f + 1)) < size) {
//            if (table[k] == null){
//                k++;
//            }
            if (k + 1 < size && table[k] > table[k + 1]) {
                k++;
            }
            if (table[k] >= table[f]) {

                break;
            }

//            Comparable kVal = (Comparable) table[k];
//            if (k+1 <size) {
//                Comparable k1Val = (Comparable) table[k + 1];
//                if (k1Val.compareTo(k) < 0) {
//                    k++;
//                }
//            }
//            Comparable fVal = (Comparable) table[f];
//
//            if (kVal.compareTo(fVal) >= 0) {
//                break;
//            }

            int i = table[k];
            table[k] = table[f];
            table[f] = i;
            f = k;
        }
    }

    public static void main(String[] args) {
//        TestMinHeap1 testMinHeap = new TestMinHeap1();
//        testMinHeap.push(1);
//        testMinHeap.push(5);
//        testMinHeap.push(3);
//        testMinHeap.push(2);
//        testMinHeap.push(8);
//        testMinHeap.push(10);
//        int size = testMinHeap.size;
//        for (int i = 0; i < size; i++) {
//            System.out.println(testMinHeap.pop());
//        }
        lengthOfLongestSubstring("abcabcbb");
    }



    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){

            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }


}
