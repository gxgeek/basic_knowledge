//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 573 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：从前序与中序遍历序列构造二叉树
////根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 573 👎 0

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class GX_105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new GX_105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    HashMap<Integer, Integer> map = new HashMap<>();
//
    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return doBuildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

        private TreeNode doBuildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        if (pStart >= pEnd){
            return null;
        }
        //头结点
        int headVal = preorder[pStart];
        TreeNode current = new TreeNode(headVal);

        int inMid = map.get(headVal);
        if(inStart == inEnd || pStart == pEnd){
            return current;
        }

//        for (int i = inStart; i < inEnd ; i++) {
//            if (headVal == inorder[i]){
//                inMid = i;
//                break;
//            }
//        }
        int leaft = inMid - inStart;
        current.left = doBuildTree(preorder, pStart + 1, pStart + leaft + 1, inorder, inStart, inMid);
        current.right = doBuildTree(preorder, pStart + leaft + 1, pEnd, inorder, inMid + 1, inEnd);
        return current;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
