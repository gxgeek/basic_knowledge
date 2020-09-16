package com.gxgeek.sort;

public class findNumInRotateArr {

    public static double minNumberInRotateArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        int size = nums.length;
        if (size % 2 == 1) {
            return nums[(left + size / 2) % size];
        } else {
//            (left + size / 2) % size   (left + (size - 1) / 2) % size
            return (double) (nums[(left + size / 2) % size] + nums[(left + (size - 1) / 2) % size]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 1, 2, 3, 4, 5};
        System.out.println(minNumberInRotateArray(arr));
    }

}
