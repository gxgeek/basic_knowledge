//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 560 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：搜索插入位置
////给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 560 👎 0
	
public class GX_35_SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new GX_35_SearchInsertPosition().new Solution();
        // TO TEST
        solution.searchInsert(new int[]{1, 3, 5, 6}, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0){
            return 0;
        }

        int start =0;
        int end = nums.length-1;

        while (start+1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > target){
                end = mid;
            }else if(nums[mid] < target){
                start = mid;
            }else {
                start = mid;
            }
        }


        if (nums[start] >= target){
            return start;
        }else if (nums[end] >= target){
            return end;
        } else if (nums[end] < target){
            return end+1;
        }

        return -1;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
