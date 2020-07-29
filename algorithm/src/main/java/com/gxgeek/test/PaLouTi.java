package com.gxgeek.test;

public class PaLouTi {

    int[] memo;

    public int palouti(int n) {
        memo = new int[n+1];
        return doPalouti(n, 3, 0);
    }

    private int doPalouti(int ladder, int maxJump, int lastJump) {
        if (ladder == 0) {
            return 1;
        }
        if (memo[ladder] != 0){
            return memo[ladder];
        }
        if (ladder < maxJump) {
            maxJump = ladder;
        }
        int jump = 0;
        for (int i = 1; i < maxJump; i++) {
            if (i != lastJump) {
                jump += doPalouti(ladder - i, maxJump, i);
            }
        }
        memo[ladder] = jump;
        return jump;
    }

    public static void main(String[] args) {
        int palouti = new PaLouTi().palouti(3);

        System.out.println(palouti);
    }



}
