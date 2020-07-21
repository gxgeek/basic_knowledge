//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 291 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：二叉树的最小深度
////给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 291 👎 0

import java.util.LinkedList;

public class GX_111_MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new GX_111_MinimumDepthOfBinaryTree().new Solution();
        // TO TEST
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(5);
        solution.minDepth(treeNode);
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
    public int minDepth(TreeNode root) {
        if (root == null)return 0;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int minDepth = 1;
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = linkedList.pollFirst();
                if (treeNode.left ==null && treeNode.right == null){
                    return minDepth;
                }

                if (treeNode.left != null){
                    linkedList.addLast(treeNode.left);
                }

                if (treeNode.right != null){
                    linkedList.addLast(treeNode.right);
                }
            }
            minDepth++;
        }
        return minDepth;
//        if (root==null) return 0;
//        if (root.left  ==null && root.right ==null){
//            return 1;
//        }
//        int i = minDepth(root.left);
//        int i1 = minDepth(root.right);
//        if (root.right == n)
//        return Math.min(i, i1) + 1;
//        int i = doMin(root);
//        return i == -1?0:i;
    }

    private int doMin(TreeNode root) {
        if(root == null){
            return -1;
        }
        int i = minDepth(root.left);
        if (i == -1){
            return -1;
        }
        int i1 = minDepth(root.right);
        if (i1 == -1){
            return -1;
        }
        return Math.min(i,i1)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

}
