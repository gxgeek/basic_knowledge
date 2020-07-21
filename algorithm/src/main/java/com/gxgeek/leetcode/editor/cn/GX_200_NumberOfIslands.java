//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 661 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：岛屿数量
////给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 661 👎 0
	
public class GX_200_NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new GX_200_NumberOfIslands().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int numIslands(char[][] grid) {
            int total = 0;
            for(int row = 0;row<grid.length;row++){
                for(int col =0;col<grid[row].length;col++){
                    if(grid[row][col] != '1'){
                        continue;
                    }
                    total += isLands(row,col,grid);
                }
            }
            return total;
        }

        public Integer isLands(int row,int col,char[][] grid){
            int sum = 0;
            if(row>0){
                sum +=change(grid[row-1][col]);
            }
            if(row+1<grid.length){
                sum +=change(grid[row+1][col]);
            }
            if(col>0){
                sum +=change(grid[row][col-1]);
            }
            if(col+1<grid[row].length){
                sum +=change(grid[row][col+1]);
            }
            return sum>2?0:1;

        }
        public Integer change(char c){
            return Integer.valueOf(String.valueOf(c));
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
