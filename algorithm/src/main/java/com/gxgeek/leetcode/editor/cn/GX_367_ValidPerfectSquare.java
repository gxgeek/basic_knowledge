//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 147 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：有效的完全平方数
////给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 147 👎 0
	
public class GX_367_ValidPerfectSquare{
    public static void main(String[] args) {
        Solution solution = new GX_367_ValidPerfectSquare().new Solution();
        // TO TEST
        solution.isPerfectSquare(808201);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long start = 1;
        long end = num;
        while (start+1<end){
            long mid = start + (end - start) / 2;
            if(mid*mid>num){
                end = mid;
            } else if (mid * mid < num) {
                start = mid;
            }else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
