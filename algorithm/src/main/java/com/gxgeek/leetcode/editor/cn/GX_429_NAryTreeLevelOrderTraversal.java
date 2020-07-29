//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 97 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：N叉树的层序遍历
////给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 97 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GX_429_NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new GX_429_NAryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            LinkedList<Node> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = deque.size();
                while (size-- > 0) {
                    Node node = deque.pollFirst();
                    list.add(node.val);
                    if (node.children != null){
                        deque.addAll(node.children);
                    }
                }
                res.add(list);
            }
            return res;

        }
//        public List<List<Integer>> levelOrder(Node root) {
//            List<List<Integer>> list = new ArrayList<>();
//            if (root == null){
//                return list;
//            }
//            LinkedList<Node> linkedList = new LinkedList<>();
//            linkedList.add(root);
//            while (!linkedList.isEmpty()){
//                int size = linkedList.size();
//                List<Integer> temp = new ArrayList<>();
//                for (int i = 0; i < size; i++) {
//
//                    Node node = linkedList.pollFirst();
//                    temp.add(node.val);
//                    if (node.children != null){
//                        linkedList.addAll(node.children);
//                    }
//                }
//                list.add(temp);
//            }
//            return list;
//        }
    }

    ;

//leetcode submit region end(Prohibit modification and deletion)

}
