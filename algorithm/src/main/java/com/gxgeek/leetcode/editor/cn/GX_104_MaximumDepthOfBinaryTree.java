//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 600 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：二叉树的最大深度
////给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 600 👎 0

import java.util.LinkedList;

public class GX_104_MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new GX_104_MaximumDepthOfBinaryTree().new Solution();
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
    int max = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root, 0);
    }
    int dfs(TreeNode root,int len){
        if (root == null){
            return len;
        }
        int maxLeft = dfs(root.left,len+1);
        int maxRigth = dfs(root.right,len+1);
        return Math.max(maxLeft, maxRigth);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
