//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 662 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：子集
////给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 662 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GX_78_Subsets{
    public static void main(String[] args) {
        Solution solution = new GX_78_Subsets().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length<1){
            return res;
        }
        help(nums, 0, new Stack<>());
        return res;
    }

        private void help(int[] nums, int startIndex, Stack<Object> stack) {

            res.add(new ArrayList(stack));
            if (startIndex == nums.length) {
                return;
            }
//            help(nums, startIndex + 1, stack);
//            stack.push(nums[startIndex]);
//            help(nums, startIndex + 1, stack);
//            stack.pop();

            for (int j = startIndex; j < nums.length; j++) {
                stack.push(nums[startIndex]);
                help(nums, j + 1, stack);
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
