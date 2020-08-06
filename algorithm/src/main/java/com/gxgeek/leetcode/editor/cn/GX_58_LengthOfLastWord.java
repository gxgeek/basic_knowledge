//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 226 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：最后一个单词的长度
////给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 226 👎 0

import java.util.*;

public class GX_58_LengthOfLastWord{
    public static void main(String[] args) {
        Solution solution = new GX_58_LengthOfLastWord().new Solution();
        // TO TEST
        solution.lengthOfLastWord(" ");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        boolean find = false;
        int len = 0;
        char[] chars = s.toCharArray();
        for (int i = 0 ; i < chars.length; i++) {
            if (chars[i] == ' '){
                len = 0;
                find = true;
            }else{
                len++;
            }
        }
        return len;

    }
        public List<Integer> findAnagrams(String s, String p) {

            int move = 0;
            int[] base = new int[108];
            int[] change = new int[108];
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < p.length();i++) {
                char c = p.charAt(i);
                if (base[c - 'A'] == 0){
                    move++;
                }
                base[p.charAt(i) - 'A']++;
            }
            int right  = 0, left = 0;
            int remove = 0;
            while (right < s.length()){
                char newChar = s.charAt(right);
                right++;
                if (base[newChar-'A'] != 0){
                    change[newChar-'A']++;
                    if (change[newChar-'A'] == base[newChar-'A']){
                        remove ++;
                    }
                }

                if (right-left >= p.length()){
                    if (right-left == p.length() && remove == move){
                        res.add(left);
                    }
                    char popChar = s.charAt(left);
                    if (base[popChar-'A'] != 0){
                        if (change[popChar-'A'] == base[popChar-'A']){
                            remove--;
                        }
                        change[popChar-'A']--;
                    }

                    left++;
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
