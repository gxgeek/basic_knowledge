//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 634 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：跳跃游戏 II
////给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 634 👎 0
	
public class GX_45_JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new GX_45_JumpGameIi().new Solution();
        // TO TEST
//        solution.jump(new int[]{2, 3, 1, 1, 4});
        isPalindrome("race a car");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
//        int j = nums.length-2;
//
//        int min = nums.length-1;
//        int count = 0;
//        while (j >= 0){
//            while (j >= 0 && nums[j] + j  >=  min){
//                j--;
//            }
//            count++;
//        }
//        return j <= 0 ?count:-1;
//


//        int step = 0;
//
//        int max = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (i+nums[i]>max  ){
//                step++;
//                max = Math.max(i + nums[i], max);
//                if (max>=nums.length){
//                    break;
//                }
//            }
//        }
//        return step;
        int step = 0;

        int max = nums.length-1;
        while (max>0){
            for (int i = 0; i < max; i++) {
                if (i+nums[i]>=max){
                    max = i;
                    step++;
                }
            }
        }
        return step;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars){
            if (c >= '0' && c <= '9'){
                sb.append(c);
            }else if (c >= 'A' && c <= 'Z'){
                sb.append((char)(c+32));
            }else if (c >= 'a' && c <= 'z'){
                sb.append(c);
            }
        }
        return sb.reverse().toString().equals(sb.toString());
    }


    public int maxProfit(int[] prices) {

        int k =2;
        int[][][] int0 = new int[prices.length + 1][k+1][2];
        int[][][] int1 = new int[prices.length + 1][k+1][2];


        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j <=k ; j++) {
                if (i == 0){
                    int0[i][j][0] = 0;
                    int1[i][j][1] = Integer.MIN_VALUE;

                }else if (j == 0){
                    int0[i][j][0] = 0;
                    int1[i][j][1] = Integer.MIN_VALUE;
                }
                else{
                    int0[i][j][0] = Math.max(int0[i-1][j][0],int0[i-1][j-1][1] + prices[i-1]);
                    int1[i][j][1] = Math.max(int0[i-1][j][1],int0[i-1][j-1][0] - prices[i-1]);
                }
            }
        }
        return int0[prices.length][k][0];

    }


}
