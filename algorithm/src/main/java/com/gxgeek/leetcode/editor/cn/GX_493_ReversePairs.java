//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 115 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：翻转对
////给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 115 👎 0

import java.util.Arrays;

public class GX_493_ReversePairs{
    public static void main(String[] args) {
        Solution solution = new GX_493_ReversePairs().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int count = 0;
        public int reversePairs(int[] nums) {
            return mergeSort(nums,0,nums.length-1);
        }

        int mergeSort(int[]nums,int begin,int end){
            if (begin >= end) return 0;
            int mid = begin+(end-begin)/2;
            int count = mergeSort(nums,begin,mid)+mergeSort(nums,mid+1,end);
            for (int i = begin,j = mid+1; i <= mid; i++){
                while(j<= end && nums[i]/2.0 > nums[j]) j++;
                count += j-(mid+1);
            }
            Arrays.sort(nums,begin,end+1);
            return count;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
