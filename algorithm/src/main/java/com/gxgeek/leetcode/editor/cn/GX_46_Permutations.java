//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 791 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：全排列
////给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 791 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GX_46_Permutations{
    public static void main(String[] args) {
        Solution solution = new GX_46_Permutations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0){
                return res;
            }
            boolean[] used = new boolean[nums.length];
            Stack<Integer> stack = new Stack<>();
            doPermute(nums, stack, used);
            return res;
    }

        private void doPermute(int[] nums, Stack<Integer> stack, boolean[] used) {
            if (nums.length == stack.size()){
                res.add(new ArrayList<>(stack));
                return;
            }


            for (int i = 0; i < nums.length; i++) {
                if (used[i] == true){
                    continue;
                }
                used[i] = true;
                stack.push(nums[i]);
                doPermute(nums, stack, used);
                used[i] = false;
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
