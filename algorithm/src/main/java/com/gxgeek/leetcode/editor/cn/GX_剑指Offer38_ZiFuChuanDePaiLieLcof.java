//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 76 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：字符串的排列
////输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 76 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GX_剑指Offer38_ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
        Solution solution = new GX_剑指Offer38_ZiFuChuanDePaiLieLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        dfs(chars, used, "");
        return res.toArray(new String[res.size()]);
    }

        private void dfs(char[] chars, boolean[] used, String s) {
            if (s.length() == chars.length){
                res.add(s);
                return;
            }
            for (int i = 0; i < chars.length;i++) {
                if (used[i]) continue;
                if (i > 0 && chars[i] == chars[i-1] && used[i-1]) break;
                used[i] = true;
                dfs(chars, used, s + chars[i]);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
