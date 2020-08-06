//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 161 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：字符串的排列
////给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 161 👎 0
	
public class GX_567_PermutationInString{
    public static void main(String[] args) {
        Solution solution = new GX_567_PermutationInString().new Solution();
        // TO TEST
        solution.checkInclusion("abc",
                "ccccbbbbaaaa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] wind = new int[26];
        int[] match = new int[26];
        int needMath = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(match[s1.charAt(i)-'a']==0)needMath++;
            match[s1.charAt(i)-'a']++;
        }
        int left = 0,right = 0;
        int matchCount = 0;
        while(right < s2.length()){
            char newChar = s2.charAt(right);
            right++;
            if (match[newChar-'a'] != 0){
                wind[newChar-'a']++;
                if (wind[newChar-'a'] == match[newChar-'a']) matchCount++;
            }
            if(right-left >= s1.length()) {
                if (right-left == s1.length() && needMath == matchCount){
                    return true;
                }
                char popChar = s2.charAt(left);
                if(match[popChar - 'a'] != 0){
                    if (match[popChar-'a'] == wind[popChar-'a']) matchCount--;
                    wind[popChar-'a']--;
                }
                left++;
            }
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
