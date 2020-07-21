//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 121 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：二叉搜索树的最小绝对差
////给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 121 👎 0
	
public class GX_530_MinimumAbsoluteDifferenceInBst{
    public static void main(String[] args) {
        Solution solution = new GX_530_MinimumAbsoluteDifferenceInBst().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    char[][] globalBoard;
    int[] dx = new int[] {1,-1,0,0};
    int[] dy = new int [] {0,0,1,-1};
    boolean[][] used;
    public char[][] updateBoard(char[][] board, int[] click) {

        int row = click[0];
        int col = click[0];
        globalBoard = board;

        if(globalBoard[row][col] == 'M'){
            globalBoard[row][col] = 'X';
            return globalBoard;
        }
        used = new boolean[board.length][board[0].length];
        help(row,col);
        return globalBoard;
    }

    void help(int row,int col){
        used[row][col] = true;
        if(globalBoard[row][col] == 'M'){
            globalBoard[row][col] = 'X';
            return ;
        }
        boolean findBoom = false;
        int findCount = 0;
        for(int i = 0;i<dx.length;i++){
            int x= row+dx[i],y=col+dy[i];
            if(x >=0 && x<globalBoard.length && y>=0 && y<globalBoard[row].length){
                if(globalBoard[x][y] == 'M'){
                    findBoom = true;
                    findCount++;
                }
            }
        }
        if(!findBoom){
            globalBoard[row][col] = 'B';
        }else{
            globalBoard[row][col] = Character.valueOf( String.valueOf(findCount).charAt(0));
        }

        if(!findBoom){
            for(int i = 0;i<dx.length;i++){
                int x= row+dx[i],y=col+dy[i];
                if(x >=0 && x<globalBoard.length && y>=0 && y<globalBoard[row].length){
                    help(x,y);
                }
            }

        }



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
