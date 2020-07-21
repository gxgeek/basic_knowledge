//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 709 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：零钱兑换
////给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 709 👎 0
	
public class GX_322_CoinChange{
    public static void main(String[] args) {
        Solution solution = new GX_322_CoinChange().new Solution();
        // TO TEST
        solution.coinChange(new int[]{1, 2,5}, 11);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] tCoins;

        int[] tempAmoutResult;
        public int coinChange(int[] coins, int amount) {
            tCoins = coins;
            tempAmoutResult = new int[amount+1];
            int dfs = dfs( amount);
            return dfs;

        }

        private int dfs( int amount) {

            if (amount<0){
                return -1;
            }
            if (amount==0){
                return 0;
            }
            if (tempAmoutResult[amount]!=0){
                return tempAmoutResult[amount];
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < tCoins.length; i++) {
                int dfs = dfs(amount-tCoins[i]);
                if (dfs==-1){
                    continue;
                }
                min = Math.min(min, dfs+1);
            }
            if (min == Integer.MAX_VALUE){
                min = -1;
            }
            tempAmoutResult[amount] = min;
            return min;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
