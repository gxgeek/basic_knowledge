//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 132 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：N皇后 II
////n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 132 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GX_52_NQueensIi{
    public static void main(String[] args) {
        Solution solution = new GX_52_NQueensIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();
    Set<Integer> col = new HashSet<>();
        //    ArrayList<Integer> res = new ArrayList<>();
        Integer res = 0;
    public int totalNQueens(int n) {
        if (n <1){
            return 0;
        }
        help(n, 0);
        return res;

    }

        private void help(int n, int rowStart) {

            if(rowStart == n){
                res++;
                return;
            }

            for (int i = 0; i < n; i++) {
                if (col.contains(i) ||  pie.contains(rowStart -i) || na.contains(rowStart+i))  {
                    continue;
                }
                col.add(i);
                pie.add(rowStart - i);
                na.add(rowStart + i);

                help(n,rowStart+1);

                col.remove(i);
                pie.remove(rowStart - i);
                na.remove(rowStart + i);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
