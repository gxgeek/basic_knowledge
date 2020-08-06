//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 348 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：分割等和子集
////给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 348 👎 0

public class GX_416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new GX_416_PartitionEqualSubsetSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {

            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;
            int subSum = sum / 2;
            int row = nums.length;
            int col = subSum;
            boolean[][] dp = new boolean[row+1][col+1];
            for (int i = 0 ; i <=row; i++) {
                dp[i][0] = true;
            }
            for (int i = 1 ; i <=row ; i++) {
                for (int j = 1; j <= col; j++) {
                    if (j >= nums[i-1]){
                        dp[i][j] = dp[i - 1][j] || dp[i-1][j - nums[i]];
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }

                }
            }
            return dp[row][col];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
