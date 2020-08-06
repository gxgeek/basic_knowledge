//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 481 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：解数独
////编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 481 👎 0
	
public class GX_37_SudokuSolver{
    public static void main(String[] args) {
        Solution solution = new GX_37_SudokuSolver().new Solution();
        // TO TEST
        char[][] c = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solution.solveSudoku(c);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        boolean[][] pie;
        boolean[][] row;
        boolean[][] col;
        boolean flag = false;
        public void solveSudoku(char[][] board) {
            int rowValue = board.length;
            int colValue = board[0].length;
            pie = new boolean[10][10];
            row = new boolean[rowValue][10];
            col = new boolean[colValue][10];

            for (int i = 0; i < rowValue; i++) {
                for (int j = 0;j < colValue; j++) {
                    if(board[i][j] >= '1' && board[i][j] <= '9' ){
                        int value = Integer.parseInt(String.valueOf(board[i][j]));
                        row[i][value] = true;
                        col[j][value] = true;
                        pie[1][value] = true;
                    }
                }
            }

//            dfs(board);
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
