//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划 
// 👍 489 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：最大正方形
////在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划 
// 👍 489 👎 0
	
public class GX_221_MaximalSquare{
    public static void main(String[] args) {
        Solution solution = new GX_221_MaximalSquare().new Solution();
        // TO TEST
        char[][] c = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        solution.maximalSquare(c);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0){
                return 0;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] dp = new int[row+1][col+1];
            int max = 0;
            for (int i = 1; i < row+1; i++) {
                for (int j = 1; j < col+1; j++) {
                    if (matrix[i-1][j-1] == '1'){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                        max = Math.max(max,dp[i][j]);
                    }
                }
            }
            return max;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
