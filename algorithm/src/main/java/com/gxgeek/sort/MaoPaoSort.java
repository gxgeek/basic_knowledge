package com.gxgeek.sort;

public class MaoPaoSort {

    public static void main(String[] args) {
        int[] sortNum = new int[]{10, 13, 424, 124, 4, 0, -1};
        maopao(sortNum);
        for (int i : sortNum) {
            System.out.println(i);
        }
    }

    public static void maopao(int[] sortNum){
        for (int i = 0; i < sortNum.length-1; i++) {
            for (int j = 0; j < sortNum.length-i-1; j++) {
                if (sortNum[j]>sortNum[j+1]){
                    int t = sortNum[j];
                    sortNum[j] = sortNum[j+1];
                    sortNum[j + 1] = t;
                }
            }
        }
    }
}
