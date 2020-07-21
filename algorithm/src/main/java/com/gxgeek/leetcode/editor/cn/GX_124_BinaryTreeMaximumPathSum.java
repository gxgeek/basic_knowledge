//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索 
// 👍 596 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：二叉树中的最大路径和
////给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索 
// 👍 596 👎 0
	
public class GX_124_BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
        Solution solution = new GX_124_BinaryTreeMaximumPathSum().new Solution();
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
    Integer maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        doMax(root);
        return maxPath;
    }

    private int doMax(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftMax = Math.max(doMax(root.left),0);
        int rightMax = Math.max(doMax(root.right),0);

        maxPath = Math.max(leftMax + rightMax + root.val,maxPath);
        return Math.max(leftMax, rightMax) + root.val;

    }
}
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
//leetcode submit region end(Prohibit modification and deletion)

}
