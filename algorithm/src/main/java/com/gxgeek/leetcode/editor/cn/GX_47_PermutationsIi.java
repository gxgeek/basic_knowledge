//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 349 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：全排列 II
////给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 349 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GX_47_PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new GX_47_PermutationsIi().new Solution();
        // TO TEST
        solution.permuteUnique(new int[]{1, 1, 2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            if(nums.length == 0){
                return res;
            }
            Arrays.sort(nums);
            Stack<Integer> stack = new Stack<Integer>();
            boolean[] use = new boolean[nums.length];
            doPermute(nums,stack,use);
            return res;
        }

        void doPermute(int[] nums,Stack<Integer> stack,boolean[] use){
            if(stack.size() == nums.length){
                res.add(new ArrayList(stack));
                return;
            }
            for(int i = 0;i<nums.length;i++  ){
                if(use[i] == true){
                    continue;
                }
                if(i >0 && nums[i] == nums[i-1] && use[i-1]){
                    break;
                }
                int indexValue = nums[i];
                stack.push(indexValue);
                use[i] = true;
                doPermute(nums,stack,use);
                stack.pop();
                use[i] = false;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
