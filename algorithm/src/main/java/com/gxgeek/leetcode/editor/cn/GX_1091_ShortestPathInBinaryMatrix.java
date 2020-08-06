//在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。 
//
// 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成： 
//
// 
// 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角） 
// C_1 位于 (0, 0)（即，值为 grid[0][0]） 
// C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]） 
// 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0） 
// 
//
// 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：[[0,1],[1,0]]
//
//输出：2
//
// 
//
// 示例 2： 
//
// 输入：[[0,0,0],[1,1,0],[1,1,0]]
//
//输出：4
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 
// 👍 49 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：二进制矩阵中的最短路径
////在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。 
//
// 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成： 
//
// 
// 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角） 
// C_1 位于 (0, 0)（即，值为 grid[0][0]） 
// C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]） 
// 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0） 
// 
//
// 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：[[0,1],[1,0]]
//
//输出：2
//
// 
//
// 示例 2： 
//
// 输入：[[0,0,0],[1,1,0],[1,1,0]]
//
//输出：4
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 
// 👍 49 👎 0

import java.util.*;

public class GX_1091_ShortestPathInBinaryMatrix{
    public static void main(String[] args) {
        Solution solution = new GX_1091_ShortestPathInBinaryMatrix().new Solution();
        // TO TEST
        solution.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int len;

        int[] dx = new int[]{1,-1,1,-1,1,-1,0,0 };
        int[] dy = new int[]{1,-1,1,-1,0,0,1,-1};
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) {
                return -1;
            }
            len = grid.length;
            if (grid[0][0] == 1 || grid[len -1][len -1] == 1){
                return -1;
            }
            int step = 1;
            LinkedList<Integer> deque = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            deque.add(0);
            visited.add(0);
            while(!deque.isEmpty()){
                int size = deque.size();
                while (size-- > 0) {
                    int popValue = deque.pop();
                    int i = popValue%len;
                    int j = popValue/len;
                    if (j  == len-1 && i == len -1){
                        return step;
                    }
                    for (int k = 0; k < dx.length ; k++) {
                        int newY = dy[k] + i;
                        int newX = dx[k] + j;
                        if (newX >= 0 && newX < len && newY >= 0 && newY < len && grid[newY][newX] == 0){
                            int xyValue = newX * len + newY;
                            if (!visited.contains(xyValue)){
                                visited.add(xyValue);
                                deque.add(xyValue);
                            }
                        }
                    }
                }
                step++;
            }
            return -1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
