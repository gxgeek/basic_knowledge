package com.gxgeek;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BackPackII {
    public static void main(String[] args) {
        backPackII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4});
    }
    public static int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int row = A.length;

        //                第I 个物品入袋子   容量为 m 最大值得时候
        int[][] dp = new int[row+1][m+1];

        for (int i = 1; i < row+1 ; i++) {
            for (int j = 1; j < m+1 ;j++) {
                if (m - A[i-1]  < 0 ){
                    //如果装不下 就是上一个物品的最大值
                    dp[i][j] = dp[i-1][j];
                }else{
                    //装的下就是 前一个的价值比较  这个
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-A[i+-1]] + V[i-1]);
                }
            }
        }


        return dp[row][m];
    }

}
