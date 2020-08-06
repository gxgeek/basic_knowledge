//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 449 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：x 的平方根
////实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 449 👎 0
	
public class GX_69_Sqrtx{
    public static void main(String[] args) {
        Solution solution = new GX_69_Sqrtx().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x<2){
            return x;
        }
        long start = 1;
        long end = x;

        while (start+1<end){
            long mid = start + (end - start) / 2;
            if (mid*mid > x){
                end = mid;
            }else {
                start = mid;
            }
        }
        return (int) start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
