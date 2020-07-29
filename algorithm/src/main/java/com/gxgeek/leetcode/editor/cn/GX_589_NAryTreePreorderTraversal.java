//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 87 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：N叉树的前序遍历
////给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 87 👎 0

import java.util.*;

public class GX_589_NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new GX_589_NAryTreePreorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            Node node = nodes.pollLast();
            res.add(node.val);
            if (node.children!=null){
                Collections.reverse(node.children);
                nodes.addAll(node.children);
            }
        }
        return res;


    }








//    public List<Integer> preorder(Node root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null){
//            return list;
//        }
//        LinkedList<Node> linkedList = new LinkedList<>();
//        linkedList.add(root);
//        while (!linkedList.isEmpty()){
//            Node node = linkedList.pollLast();
//            list.add(node.val);
//            if (node.children != null){
//                Collections.reverse(node.children);
//                linkedList.addAll(node.children);
//            }
//        }
//        return list;
//
//    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
