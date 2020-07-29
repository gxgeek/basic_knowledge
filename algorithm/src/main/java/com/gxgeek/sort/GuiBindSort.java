package com.gxgeek.sort;

public class GuiBindSort {
    public static void main(String[] args) {
        int[] sortNum = new int[]{10, 13, 424, 124, 4, 0, -1};
        sort(sortNum,0,sortNum.length-1);
        for (int i : sortNum) {
            System.out.println(i);
        }

    }


    public static void sort(int[]nums,int left,int right){
        if (left>=right){
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums,  mid+1,right);
        merge(nums, left, mid,right);

    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = 0;
        int[] temp = new int[right - left+1];
        while (i <= mid && j <= right){
            if (nums[i] > nums[j]) temp[k++] = nums[j++];
            else temp[k++] = nums[i++];
        }
        while (i < mid+1) temp[k++] = nums[i++];
        while (j < right+1) temp[k++] = nums[j++];

        for (int t = 0 ;t < temp.length;t ++){
            nums[left + t] = temp[t];
        }
    }
}
