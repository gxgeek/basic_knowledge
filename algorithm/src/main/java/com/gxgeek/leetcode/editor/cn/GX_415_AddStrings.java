//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 248 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：字符串相加
////给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 248 👎 0
	
public class GX_415_AddStrings{
    public static void main(String[] args) {
        Solution solution = new GX_415_AddStrings().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length()-1;
        int idex2 = num2.length()-1;
        int c= 0;
        StringBuilder sb = new StringBuilder();
        while(index1 >= 0 || idex2 >= 0) {
            int n1 = index1 >= 0 ? num1.charAt(index1)-'0' : 0;
            int n2 = idex2 >= 0 ? num2.charAt(idex2)-'0' : 0;
            int sum = n1 + n2 + c;
            c = sum / 10;
            sb.append(sum % 10);
            idex2--;
            index1--;
        }
        if (c != 0){
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
