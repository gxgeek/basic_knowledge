//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串 
// 👍 124 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：转换成小写字母
////实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串 
// 👍 124 👎 0
	
public class GX_709_ToLowerCase{
    public static void main(String[] args) {
        Solution solution = new GX_709_ToLowerCase().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toLowerCase(String str) {
        char[] charArrays = str.toCharArray();
        char[] newChars = new char[charArrays.length];
        for (int i = 0 ; i < charArrays.length; i++) {
            if(charArrays[i] >= 'a' && charArrays[i] <= 'z' ){
                newChars[i] = charArrays[i];
            }else{
                newChars[i] = (char) (charArrays[i] -32);
            }
        }
        return new String(newChars);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
