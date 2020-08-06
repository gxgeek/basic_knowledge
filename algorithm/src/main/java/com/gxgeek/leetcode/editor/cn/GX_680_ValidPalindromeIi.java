//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 238 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：验证回文字符串 Ⅱ
////给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 238 👎 0
	
public class GX_680_ValidPalindromeIi{
    public static void main(String[] args) {
        Solution solution = new GX_680_ValidPalindromeIi().new Solution();
        // TO TEST
        solution.validPalindrome("abca");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean validPalindrome(String s) {
            if (s.length() <= 1) return true;
            if (check(s)) return true;
            int i = 0;
            int j = s.length()-1;
            boolean falg =false;
            while(i < j){
                if (s.charAt(i++) != s.charAt(j--)){
                    return check(s.substring(0,i-1)+s.substring(j,s.length()));
                }
            }
            return true;

        }


        boolean check(String str){
            int i = 0;
            int j = str.length()-1;
            while(i < j){
                if (str.charAt(i++) != str.charAt(j--)){
                    return false;
                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
