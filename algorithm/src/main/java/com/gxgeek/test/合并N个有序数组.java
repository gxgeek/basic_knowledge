package com.gxgeek.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并N个有序数组 {
    public static void main(String[] args) {
        int[][] nums = {{1, 4, 8, 9}, {2, 3, 6, 10}, {5, 18, 20, 36}};
        for (int num : mergeArray(nums)) {
            System.out.println(num);
        }
    }

    private static int[] mergeArray(int[][] nums) {
        return null;
//        Arrays.sort(nums, Comparator.comparingInt(n -> n[0]));
//        int[] newInt = nums[0];
//        List<int[]> res = new ArrayList<>();
//        res.add(newInt);

//        for (int[] num : nums) {
//
//
//        }

//
//        for (int i = 1; i < nums.length; i++){
//            if (newInt[newInt.length-1] >= nums[i][0]){
//
//            }
//        }
    }

}
