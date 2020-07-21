//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 3991 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：无重复字符的最长子串
////给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 3991 👎 0

import java.util.HashMap;
import java.util.Map;

public class GX_3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new GX_3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        solution.lengthOfLongestSubstring("abcabcbb");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> map = new HashMap<>();
            int max = 0;
            int leaft = -1;
            for(int i = 0;i<s.length()-1;i++){
                Character cc = s.charAt(i);
                if(map.containsKey(cc)){
                    leaft = Math.max(leaft,map.get(cc));
                }
//                String s = "....";
//                s.re

                map.put(cc,i);
                max = Math.max(i-leaft,max);
            }
            return max;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
