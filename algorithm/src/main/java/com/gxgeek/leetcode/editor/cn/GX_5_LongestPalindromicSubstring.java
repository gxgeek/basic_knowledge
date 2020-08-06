//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2481 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：最长回文子串
////给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2481 👎 0
	
public class GX_5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new GX_5_LongestPalindromicSubstring().new Solution();
        // TO TEST
        solution.longestPalindrome("cbbd");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return s;
        char[] chars = s.toCharArray();
        boolean[][] dp  = new boolean[len+1][len+1];
        dp[0][0] = true;
        int start = 0;
        int max = 1;
        for (int i = 0; i < len ;i++) {
            for (int j = len; j >= i; j--) {
                dp[i][j] = chars[i-1] == chars[j-1] ? dp[i+1][j-1] || j-i < 3 : false;
                if (dp[i][j]  && (j-i+1) > max){
                    start = i;
                    max = j-i+1;
                }
            }
        }
        return s.substring(start,start+max);

    }
//    public String longestPalindrome(String s) {
//        if (s.length() <= 1){
//            return s;
//        }
//        int length = s.length();
//        int start = 0;
//        int max = 0;
//        boolean [][]dp = new boolean[length][length];
//        for (int j = 0; j < length; j++) {
//            for (int i = j ; i>=0; i--) {
//                dp[i][j] = s.charAt(i) == s.charAt(j) ?( j-i < 3 || dp[i+1][j-1]) : false;
//                if(dp[i][j]){
//                    int len = j-i+1;
//                    if(len > max){
//                        max = Math.max(max,len);
//                        start = i;
//
//                    }
//                }
//            }
//        }
//        return s.substring(start,max);
//
//    }
//    public String longestPalindrome(String s) {
//        int begin = 0;
//        int max = 0;
//        int n = s.length();
//        boolean dp[][] = new boolean[n][n];
//        for (int i = 0; i< n; i++) {
//            dp[i][i] = true;
//        }
//        for (int j = 1; j < n ; j ++ ){
//            for (int i = j; i>=0; i--){
//                int length = j - i + 1;
//                dp[i][j] = s.charAt(i) == s.charAt(j) ? (length<=3 ||dp[i+1][j-1]):false;
//                if(dp[i][j]  && length > max){
//                    max = length;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, max+begin);
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public int maxProfit(int k, int[] prices) {

        return 0;
    }

}
