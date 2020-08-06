//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 268 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：被围绕的区域
////给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 268 👎 0
	
public class GX_130_SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new GX_130_SurroundedRegions().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};
        int tcols;
    public void solve(char[][] board) {
        int row = board.length;
        if(row<1) return;
        int col = board[0].length;
        if (col <1 ) return;
        tcols = col;
        UnionSet unionSet = new UnionSet(row * col + 1);
        Integer duumy = row * col;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != 'O') continue;
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    unionSet.union(node(i,j),duumy);
                }else {
                    for (int k = 0; k < dx.length; k++) {
                        int x = dx[k] + j;
                        int y = dy[k] + i;
                        if (x >= 0 && x < col  && y >= 0 && y < row && board[y][x] == 'O'){
                            unionSet.union(node(i,j),node(y,x) );
                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!unionSet.isSame(duumy, node(i,j))) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int node (int row,int col){
        return row * tcols + col;
    }
    
    class UnionSet{
        int[] parent;
        int count;
        public UnionSet(int size){
            count = size;
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        boolean isSame(int p,int q){
            return find(p) == find(q);
        }

        private int find(int q) {
            while(q != parent[q]){
                parent[q] = parent[parent[q]];
                q = parent[q];
            }
            return q;
        }

        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parent[root2] = root1;
            }
        }
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
