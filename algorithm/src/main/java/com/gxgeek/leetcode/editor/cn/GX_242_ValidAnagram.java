//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 216 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：有效的字母异位词
////给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 216 👎 0

import java.lang.reflect.Array;
import java.util.Arrays;

public class GX_242_ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new GX_242_ValidAnagram().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (t.length()!=s.length()){
            return false;
        }
        int[] duit = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            duit[c - 'a']++;
        }
        for (int i = 0; i <t.length(); i++) {
            duit[t.charAt(i) - 'a']--;
            if(duit[t.charAt(i) - 'a']<0){
                return false;
            }

        }
        return true;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
