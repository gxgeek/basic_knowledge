//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 53 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：在排序数组中查找数字 I
////统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 53 👎 0

import java.util.ArrayList;

public class GX_剑指Offer53_I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new GX_剑指Offer53_I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // TO TEST
        solution.search(new int[]{5, 7, 7, 8, 8, 10},
                8);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int count = 0;
        int gTarget;
        public int search(int[] nums, int target) {
            target = gTarget;
            help(nums,0,nums.length-1);
            return count;
        }
        void help(int[] nums,int start,int end) {
            if (nums[end] < gTarget || nums[start] > gTarget){
                return;
            }
            while( start <= end){
                int mid = start + (end-start)/2;
                if (gTarget == nums[mid]){
                    count++;
                    help(nums,start,mid-1);
                    help(nums,mid+1,end);
                    break;
                }else if (gTarget > nums[mid]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
