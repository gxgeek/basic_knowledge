//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1165 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：括号生成
////数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1165 👎 0

import java.util.ArrayList;
import java.util.List;

public class GX_22_GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GX_22_GenerateParentheses().new Solution();
        // TO TEST
        solution.generateParenthesis(10);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        doGenerateParenthesis(0,0,n,"");
        return list;
    }

    private void doGenerateParenthesis(int left, int right, int n, String s) {
        //先判断 退出条件
        if (left == n && right == n){
            System.out.println(s);
            list.add(s);
            return;
        }
        //left 随时加
        if(left < n){
            doGenerateParenthesis(left+1, right, n, s + "(");
        }
        //right 之前必须有 左括号 左括号大于 右括号
        if (left > right && right < n){
            doGenerateParenthesis(left, right+1, n, s + ")");
        }
        //处理当前逻辑

    }


}
//leetcode submit region end(Prohibit modification and deletion)



}
