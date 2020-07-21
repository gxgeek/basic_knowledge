//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 
// 👍 98 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：根据前序和后序遍历构造二叉树
////返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 
// 👍 98 👎 0

import java.util.HashMap;
import java.util.Map;

public class GX_889_ConstructBinaryTreeFromPreorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new GX_889_ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
        int[] s = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] ss = new int[]{4, 5, 2, 6, 7, 3, 1};
        solution.constructFromPrePost(s, ss);
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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for(int i =0;i<post.length;i++){
            map.put(post[i],i);
        }
        return help(pre,0,pre.length-1,post,0,post.length-1);
    }

    TreeNode help(int[] pre,int preStart,int preEnd, int[] post,int postStart,int postEnd){
        if(preStart > preEnd || postStart > postEnd){
            return null;
        }
        int headVal  = pre[preStart];
         TreeNode head = new TreeNode(headVal);
         if(preStart == preEnd){
             return head;
         }
        int postIndex = map.get(pre[preStart+1]);

        head.left = help(pre,preStart+1,preStart+1+(postIndex-postStart),post,postStart,postIndex);

        head.right = help(pre,preStart+1+(postIndex-postStart)+1,preEnd,post,postIndex+1,postEnd-1);
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
