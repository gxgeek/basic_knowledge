//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 323 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：找到字符串中所有字母异位词
////给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 323 👎 0

import java.util.ArrayList;
import java.util.List;

public class GX_438_FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new GX_438_FindAllAnagramsInAString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if(s.length() == 0 || p.length() == 0 || p.length() > s.length()){
                return res;
            }
            int[] need = new int[26];
            int[] wind = new int[26];
        int needMatch = 0;
        for (int i = 0; i < p.length(); i++) {
                if(need[getCharIndex(p.charAt(i))] == 0) needMatch++;
                need[getCharIndex(p.charAt(i))]++;
            }
            char[] sChars = s.toCharArray();
            int right = 0,left = 0;
            int match = 0;
            while(right < s.length()) {
                char newChar = sChars[right];
                right++;
                if (need[getCharIndex(newChar)] != 0){
                    wind[getCharIndex(newChar)]++;
                    if (wind[getCharIndex(newChar)] == need[getCharIndex(newChar)]){
                        match++;
                    }
                }

                if (right - left >= p.length()){
                    if (right - left == p.length() && match == p.length()) {
                        res.add(left);
                    }
                    char popChar = sChars[left];
                    left++;
                    if (need[getCharIndex(popChar)] != 0) {
                        if (wind[getCharIndex(popChar)] == need[getCharIndex(popChar)]){
                            match--;
                        }
                        wind[getCharIndex(popChar)]--;
                    }
                }
            }
            return res;
        }


        int getCharIndex(char c){
            return c - 'a';
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

