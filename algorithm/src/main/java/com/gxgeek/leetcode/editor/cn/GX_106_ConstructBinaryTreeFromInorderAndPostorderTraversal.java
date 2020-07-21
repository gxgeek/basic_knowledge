//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 242 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：从中序与后序遍历序列构造二叉树
////根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 242 👎 0

import java.util.HashMap;
import java.util.Map;

public class GX_106_ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new GX_106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // TO TEST
        int[] inorder =  {1,2,3,4,5,6,7};
        int[] postorder = {1,3,2,5,7,6,4};

        solution.buildTree(inorder, postorder);
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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return help(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    TreeNode help(int[] inorder,int inStart,int inEnd, int[] postorder,int ps,int pe){
        if(ps > pe || inStart > inEnd){
            return null;
        }
        // if(pStart <= pEnd){
        //     return null;
        // }
        // if (pStart <0){
        //     return null;
        // }

        int headVal = postorder[pe];
        TreeNode head = new TreeNode(headVal);
         if(inStart == inEnd || ps == pe){
             return head;
         }

        int mid = map.get(headVal);

        int right = mid-inStart;

        head.right = help(inorder,mid+1,inEnd,postorder,ps+right,pe-1);
        head.left = help(inorder,inStart,mid-1,postorder,ps,ps+right-1);
        return head;

    }



}
//leetcode submit region end(Prohibit modification and deletion)

}
