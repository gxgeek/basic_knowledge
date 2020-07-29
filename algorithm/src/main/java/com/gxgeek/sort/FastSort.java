package com.gxgeek.sort;

public class FastSort {
    public static void main(String[] args) {
        int[] sortNum = new int[]{10, 13, 424, 124, 4, 0, -1};
        quickSort(sortNum,0,sortNum.length -1);
        for (int i : sortNum) {
            System.out.println(i);
        }

    }

    static void quickSort(int[]nums,int begin,int end){
        if (begin >= end){
            return;
        }
        int pos = paratition(nums, begin, end);
        quickSort(nums,begin,pos-1);
        quickSort(nums, pos + 1, end);
    }

    private static int paratition(int[] nums, int begin, int end) {
        int pov = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pov]){
                swap(nums, i, counter);
                counter++;
            }
        }
        swap(nums, counter, pov);
        return counter;
    }

    static void swap(int[] nums, int begin, int end){
        int temp = nums[begin];
        nums[begin] = nums[end];
        nums[end] = temp;
    }
}
