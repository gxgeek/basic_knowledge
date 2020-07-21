//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 799 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：电话号码的字母组合
////给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 799 👎 0

import java.util.*;

public class GX_17_LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new GX_17_LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        solution.letterCombinations("23");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<String> res = new ArrayList<>();
        Map<Character,String> map = new HashMap<>();
        public List<String> letterCombinations(String digits) {
            map.put('2',"abc");
            map.put('3',"def");
            map.put('4',"ghi");
            map.put('5',"jkl");
            map.put('6',"mno");
            map.put('7',"pqrs");
            map.put('8',"tuv");
            map.put('9',"wxyz");

            help(digits,0,"");
            return  new ArrayList<>(res);
        }

        private void help(String digits, int start, String tempRes) {
            if (digits.length() == start){
                res.add(tempRes);
                return;
            }
            char c = digits.charAt(start);
            String s = map.get(c);
            for (int j = 0; j < s.length(); j++) {
                help(digits, start+1, tempRes + s.charAt(j));
            }
        }
    }//leetcode submit region end(Prohibit modification and deletion)

}
