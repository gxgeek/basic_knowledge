//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 258 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：验证回文串
////给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 258 👎 0
	
public class GX_125_ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new GX_125_ValidPalindrome().new Solution();
        // TO TEST
        solution.isPalindrome("A man, a plan, a canal: Panama");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char charc = chars[i];
            if (charc >= '0' &&  charc <='9'){
                sb.append(charc);
            }else if(charc >= 'A' &&  charc <='Z'){
                sb.append((char)(charc+32));
            }else if(charc >= 'a' &&  charc <='z'){
                sb.append(charc);
            }
        }
        return sb.toString().equals(sb.reverse().toString());

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
