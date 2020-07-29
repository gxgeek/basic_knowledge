//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 497 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：翻转二叉树
////翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 497 👎 0

import java.util.LinkedList;

public class GX_226_InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new GX_226_InvertBinaryTree().new Solution();
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
    public TreeNode invertTree(TreeNode root) {
        rever(root);
        return root;
    }

    private void rever(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        rever(root.left);
        rever(root.right);
    }
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null){
//            return root;
//        }
//        LinkedList<TreeNode> linkedList = new LinkedList<>();
//        linkedList.add(root);
//        while (!linkedList.isEmpty()){
//            int size = linkedList.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode treeNode = linkedList.pollFirst();
//                TreeNode temp = treeNode.right;
//                treeNode.right = treeNode.left;
//                treeNode.left = temp;
//                if (treeNode.left != null){
//                    linkedList.addLast(treeNode.left);
//                }
//                if (treeNode.right != null){
//                    linkedList.addLast(treeNode.right);
//                }
//            }
//        }
//        return root;
//    }
//    public TreeNode invertTree(TreeNode root) {
//        doInvertTree(root);
//        return root;
//    }
//
//    private void doInvertTree(TreeNode root) {
//        if (root==null){
//            return;
//        }
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        doInvertTree(root.left);
//        doInvertTree(root.right);
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
