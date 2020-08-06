//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划 
// 👍 385 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：不同路径 II
////一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划 
// 👍 385 👎 0

public class GX_63_UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new GX_63_UniquePathsIi().new Solution();
        // TO TEST
//        solution.uniquePathsWithObstacles(new int[][]{{0, 1}});
        solution.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid.length < 0 || obstacleGrid[0].length < 0) {
                return 0;
            }

            int col = obstacleGrid[0].length;
            int row = obstacleGrid.length;
            int[][] dp = new int[row][col];
            for (int i = col - 1; i >= 0; i--) {
                if (obstacleGrid[row - 1][i] != 1) {
                    if (i < col - 1 && dp[row - 1][i + 1] == 1) {
                        dp[row - 1][i] = 1;
                    } else if (i == col - 1){
                        dp[row - 1][i] = 1;
                    }
                }
            }
            for (int i = row - 1; i >= 0; i--) {
                if (obstacleGrid[i][col - 1] != 1) {
                    if (i< row - 1 && dp[i+1][col - 1] ==1){
                        dp[i][col - 1] = 1;
                    }else if(i == row - 1 ){
                        dp[i][col - 1] = 1;
                    }
                }
            }


            for (int i = dp.length - 2; i >= 0; i--) {
                for (int j = dp[0].length - 2; j >= 0; j--) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                    }
                }
            }
            return dp[0][0];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
