//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 605 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：下一个排列
////实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 605 👎 0

import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class GX_31_NextPermutation{
    public static void main(String[] args) {
        Solution solution = new GX_31_NextPermutation().new Solution();
        // TO TEST
//        solution.nextPermutation(new int[]{1, 5, 1});
        missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public void nextPermutation(int[] nums) {
            // if (nums.length < 2)
            int i = nums.length - 2;
            while(i >= 0 && nums[i] > nums[i+1])i--;
            if (i>=0){
                int j = nums.length - 1;
                while(j>=0 && nums[i] > nums[j])j--;
                swap(nums,i,j);
            }
            reverse(nums,i+1,nums.length-1);
        }

        void reverse(int[] nums,int j,int k){
            while(j < k){
                swap(nums,j,k);
                j++;
                k--;
            }
        }
        void swap(int[] nums,int j,int k){
            int t = nums[j];
            nums[j] = nums[k];
            nums[k] = t;
        }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start  +1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == mid){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        if (nums[start]-start == 1) return start;
        if (nums[end]-end == 1) return end-1;
        // return -1;
        return start;
    }

}
