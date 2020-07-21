//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 307 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：组合总和 II
////给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 307 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GX_40_CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new GX_40_CombinationSumIi().new Solution();
        // TO TEST
        List<List<Integer>> lists = solution.combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 2, 3}, 4);
        System.out.println(lists);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates,0,target,new Stack<Integer>());
            return res;
        }

        void dfs(int[] candidates,int start ,int target,Stack<Integer> stack){
            if(target<0){
                return;
            }
            if(target == 0){
                res.add(new ArrayList(stack));
                return;
            }
            for(int i=start;i<candidates.length;i++){

                if(i>start && candidates[i] == candidates[i-1] ) continue;

                stack.push(candidates[i]);
                dfs(candidates,i+1,target-candidates[i],stack);
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
