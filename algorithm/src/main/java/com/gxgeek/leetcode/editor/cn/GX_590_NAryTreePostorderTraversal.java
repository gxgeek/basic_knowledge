//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 84 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：N叉树的后序遍历
////给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 84 👎 0

import java.util.*;

public class GX_590_NAryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new GX_590_NAryTreePostorderTraversal().new Solution();
        // TO TEST

        Node node = new Node(1);
        ArrayList<Node> objects = new ArrayList<>();
        objects.add(new Node(3));
        node.children = objects;
        solution.postorder(node);
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

    static class Node {
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
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null){
            return list;
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            Node node = linkedList.pollLast();
            list.addFirst(node.val);
            if (node.children != null){
//                Collections.reverse(node.children);
                for(Node cnode : node.children){
                    linkedList.addLast(cnode);
                }
            }
        }
        return list;
    }
//    public List<Integer> postorder(Node root) {
//        List<Integer> list = new ArrayList<>();
//        Stack<Node> stack = new Stack<>();
//
//        if(root == null){
//            return list;
//        }
//        stack.push(root);
//        while(!stack.isEmpty()){
//            Node node = stack.pop();
//            if(node.children!=null){
//                stack.push(node);
//                Collections.reverse(node.children);
//                stack.addAll(node.children);
//                node.children = null;
//            }else{
//                ;
//                list.add(node.val);
//            }
//        }
//        return list;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
