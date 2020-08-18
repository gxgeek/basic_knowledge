//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 337 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：杨辉三角
////给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 337 👎 0

import java.util.ArrayList;
import java.util.List;

public class GX_118_PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new GX_118_PascalsTriangle().new Solution();
        // TO TEST
        solution.generate(5);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub1 = new ArrayList<>();
        sub1.add(1);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> sub = new ArrayList<>();
            sub.add(1);
            for (int j = 1; j < i; j++) {
                sub.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            sub.add(1);
            res.add(sub);
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
