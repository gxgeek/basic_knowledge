//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 573 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：二叉树的中序遍历
////给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 573 👎 0

import java.util.*;

public class GX_94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new GX_94_BinaryTreeInorderTraversal().new Solution();
        // TO TEST
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        solution.inorderTraversal(treeNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        LinkedList<Integer> res = new LinkedList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
//            dfs(root);
//            return res;
            if (root == null){
                return res;
            }

            LinkedList<TreeNode> nodeList = new LinkedList<>();

            while (root != null || !nodeList.isEmpty()){
                while (root != null){
                    nodeList.addLast(root);
                    root = root.left;
                }
                TreeNode treeNode = nodeList.pollLast();
                res.addLast(treeNode.val);
                root = treeNode.right;
            }
            return res;
        }
        void  dfs(TreeNode root){
            if (root == null){
                return;
            }
            dfs(root.left);
            res.addLast(root.val);
            dfs(root.right);
        }
//        public List<Integer> inorderTraversal(TreeNode root) {
//            LinkedList<Integer> res = new LinkedList<>();
//            LinkedList<TreeNode> nodeList = new LinkedList<>();
//            nodeList.add(root);
//            while (!nodeList.isEmpty()){
//                TreeNode treeNode = nodeList.pollFirst();
//                if (treeNode.left != null){
//                    nodeList.addLast(treeNode.left);
//                }
//                if (treeNode.right != null){
//                    nodeList.addLast(treeNode.right);
//                }
//            }
//        }
//        public List<Integer> inorderTraversal(TreeNode root) {
//            LinkedList<TreeNode> list = new LinkedList<>();
//            List<Integer> result = new ArrayList<>();
//            if(root == null){
//                return result;
//            }
//
//            while(root != null || !list.isEmpty()){
//                while(root != null){
//                    list.addLast(root.left);
//                    root = root.left;
//                }
//                TreeNode node  = list.pollLast();
////                result.addLast(node.val);
//                root = node.right;
//            }
//            return result;
//
//
//
//        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
