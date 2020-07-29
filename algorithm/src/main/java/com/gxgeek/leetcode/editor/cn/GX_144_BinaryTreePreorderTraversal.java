//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 308 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：二叉树的前序遍历
////给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 308 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GX_144_BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new GX_144_BinaryTreePreorderTraversal().new Solution();
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
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            TreeNode treeNode = deque.pollLast();
            res.add(treeNode.val);
            if (treeNode.right!=null){
                deque.addLast(treeNode.right);
            }
            if (treeNode.left!=null){
                deque.addLast(treeNode.left);
            }
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
//    public List<Integer> preorderTraversal(TreeNode root) {
//
//        if (root!=null)doPreorderTraversal(root);
//        return list;
//    }
//
//    private void doPreorderTraversal(TreeNode root) {
//        if (root == null){
//            return;
//        }
//        list.add(root.val);
//        doPreorderTraversal(root.left);
//        doPreorderTraversal(root.right);
//
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
