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
    public int maxDepth(TreeNode root) {

        LinkedList<TreeNode> linkedList = new LinkedList();
        if (root == null)return 0;
        int maxDepth = 0;

        linkedList.addLast(root);
        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = linkedList.pollFirst();
                if (treeNode.left != null){
                    linkedList.addLast(treeNode.left);
                }
                if (treeNode.right != null){
                    linkedList.addLast(treeNode.right);
                }
                if (i+1==size){
                    maxDepth++;
                }
            }

        }
        return maxDepth;
    }
//
//    public int maxDepth(TreeNode root) {
//        if(root == null)return 0;
//        int i = maxDepth(root.left);
//        int i1 = maxDepth(root.right);
//        return Math.max(i,i1)+1;
//    }
}
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

//leetcode submit region end(Prohibit modification and deletion)

}
