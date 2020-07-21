package com.gxgeek.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1677 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {
    public static void main(String[] args) {
        new Solution20().isValid("(");
    }
    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack=new Stack<Character>();
        for (char currentChar : chars) {
            if (currentChar == '(' || currentChar =='['|| currentChar =='{'){
                stack.push(Character.valueOf(currentChar));
            }else {
                if(stack.empty()){
                    return false;
                }
                char popChar = stack.pop().charValue();
                if (!check(popChar,currentChar)){
                    return false;
                }
            }
        }
        return true;

    }

    private boolean check(char popChar,char checkChar) {
        if (popChar == '('  &&  checkChar == ')' ){
            return true;
        }
        if (popChar == ('{') &&  checkChar == ('}')){
            return true;
        }
        if (popChar == ('[') &&  checkChar == (']')){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
