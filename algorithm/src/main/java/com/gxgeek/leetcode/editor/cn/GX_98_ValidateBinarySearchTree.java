//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 660 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：验证二叉搜索树
////给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 660 👎 0

import java.util.LinkedList;
import java.util.Stack;

public class GX_98_ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new GX_98_ValidateBinarySearchTree().new Solution();
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
    Long prevVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root ==null){
            return true;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        Long prevVal = Long.MIN_VALUE;
        TreeNode current = root;
        while (current != null || !treeNodes.isEmpty()){
            while (current!=null){
                treeNodes.addLast(current);
                current = current.left;
            }
            current = treeNodes.pollLast();
            if (current.val <= prevVal){
                return false;
            }
            prevVal = Long.valueOf(current.val);
            current = current.right;
        }
        return true;


//        Stack<TreeNode> stack = new Stack();
//        double inorder = - Double.MAX_VALUE;
//
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
//            if (root.val <= inorder) return false;
//            inorder = root.val;
//            root = root.right;
//        }
//        return true;

        //
//
////
//        if (root == null) return true;
//
//        boolean validBST = isValidBST(root.left);
//        if (!validBST){
//            return false;
//        }
//        if(root.val <= prevVal){
//            return false;
//        }
//        prevVal = Long.valueOf(root.val);
//       return isValidBST(root.right);
    }
    public void read(TreeNode root) {
        read(root.left);
        System.out.println(root.val);
        read(root.right);

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
