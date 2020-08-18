package com.gxgeek.test;

public class 使用背包最大问题 {

    private int  useMax(int C,int[] N){

        boolean[][] dp = new boolean[N.length+1][C+1];

        for (int i = 0 ; i <=N.length; i++) {
            dp[i][0] = true;
        }
        int max = 0;

        for (int i = 1; i <= N.length; i++) {
            for (int j = 0; j <= C; j++){
                if (j>= N[i-1]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-N[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                if (dp[i][j]){
                    max = Math.max(max,j);
                }
            }
        }
        return max;


    }
}
