//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 663 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：最小覆盖子串
////给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 663 👎 0
	
public class GX_76_MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new GX_76_MinimumWindowSubstring().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || t.length() > s.length()) {
            return "";
        }

        int[] need =new int[128];
        int[] wind =new int[128];
        int needMatchCount = 0;
        for (int i = 0; i < t.length(); i++) {
            if(need[t.charAt(i)-'A'] == 0) needMatchCount++;
            need[t.charAt(i)-'A']++;
        }
        int left = 0,right = 0;
        int match = 0;
        int start = 0,end = 0;
        int min = Integer.MAX_VALUE;
        while(right < s.length()){
            char newChar = s.charAt(right);
            right++;
            if (need[newChar-'A'] != 0){
                wind[newChar-'A']++;
                if(need[newChar-'A'] == wind[newChar-'A']){
                    match++;
                }
            }
            while (match == needMatchCount && right - left >= t.length()){
                if(right - left < min){
                    start = left;
                    min = right - left;
                }
                char popChar = s.charAt(left);
                left++;
                if (need[popChar - 'A'] != 0){
                    if(wind[popChar - 'A'] == need[popChar - 'A']){
                        match--;
                    }
                    wind[popChar - 'A']--;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start,start+min);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
