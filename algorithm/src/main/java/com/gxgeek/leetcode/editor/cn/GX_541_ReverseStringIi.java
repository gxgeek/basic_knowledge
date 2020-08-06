//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 83 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：反转字符串 II
////给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 83 👎 0
	
public class GX_541_ReverseStringIi{
    public static void main(String[] args) {
        Solution solution = new GX_541_ReverseStringIi().new Solution();
        // TO TEST
        solution.reverseStr("abcdefg", 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String reverseStr(String s, int k) {
            if (s.length() == 0 || k == 0) return s;
            char[] chars = s.toCharArray();
            int start = 0;
            if (start < s.length()){
                if (s.length() - start  < k){
                    reverseString(chars,start,s.length()-1);
                }else{
                    reverseString(chars,start,start+k-1);
                }
                start += 2*k;
            }
            return new String(chars);
        }


        public void reverseString(char[] s,int i,int j) {
            while (i < j){
                char t = s[i];
                s[i++] = s[j];
                s[j--] = t;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
