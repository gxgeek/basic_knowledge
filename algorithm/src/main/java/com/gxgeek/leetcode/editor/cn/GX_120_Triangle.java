//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 537 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：三角形最小路径和
////给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 537 👎 0

import java.util.Arrays;
import java.util.List;

public class GX_120_Triangle{
    public static void main(String[] args) {
        Solution solution = new GX_120_Triangle().new Solution();
        // TO TEST
        solution.minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int[][]dp = new int[triangle.size()][];
        for (int i=0;i<triangle.size();i++){
            for (int j=0;j<triangle.get(i).size();j++){
                if(dp[i] == null){
                    dp[i] = new int[triangle.get(i).size()];
                }
                dp[i][j] = triangle.get(i).get(j);
            }
        }


        for(int i = dp.length-2;i>=0;i--){
            for (int j=dp[i].length-1;j>=0;j--){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+dp[i][j];
            }
        }
        return dp[0][0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
