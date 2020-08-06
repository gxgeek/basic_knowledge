//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1428 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：正则表达式匹配
////给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1428 👎 0
	
public class GX_10_RegularExpressionMatching{
    public static void main(String[] args) {
        Solution solution = new GX_10_RegularExpressionMatching().new Solution();
        // TO TEST
        solution.isMatch("aa", "a*");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        boolean[][] memo;
        public boolean isMatch(String s, String p) {
                //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
                if (p.isEmpty())return s.isEmpty();
                //判断s和p的首字符是否匹配，注意要先判断s不为空
                boolean headMatched=!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
                if (p.length()>=2&&p.charAt(1)=='*'){//如果p的第一个元素的下一个元素是*
                    //则分别对两种情况进行判断
                    return isMatch(s,p.substring(2))||
                            (headMatched&&isMatch(s.substring(1),p));
                }else if (headMatched){//否则，如果s和p的首字符相等
                    return isMatch(s.substring(1),p.substring(1));
                }else {
                    return false;
                }



//            int i = 0;
//            int j = 0;
//            // memo = = new boolean[s.length()][p.length()];
//            return dp(s,i,p,j);
        }

        boolean dp(String s,int sStart,String p ,int pStart){
            if (sStart >= s.length())return pStart >= p.length();

            boolean first = pStart < p.length()
                    && (s.charAt(sStart) == p.charAt(pStart) || p.charAt(pStart) == '.');

            if ( pStart +1  < p.length() && p.charAt(pStart+1) == '*'){
                return dp(s,sStart,p,pStart+2) || ( first && dp(s,sStart+1,p,pStart));
            }else if (first){
                return first && dp(s,sStart+1,p,pStart+1);
            }else{
                return false;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
