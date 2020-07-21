//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 314 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：二叉树的序列化与反序列化
////序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 314 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GX_297_SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
//        Solution solution = new GX_297_SerializeAndDeserializeBinaryTree().new Solution();
        // TO TEST
//        String str = "[]";
//        Codec codec = new Codec();
//        String serialize = codec.serialize(codec.deserialize(str));
//        System.out.println(serialize);
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
public  class Codec {

    private  String NULL = "X";
    private  String spliter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null){
//            return "[]";
//        }
        StringBuilder sb = new StringBuilder();

        doSerialize(root,sb);
        return sb.toString();
//        if(list.isEmpty()){
//            return "[]";
//        }
//        StringBuilder sb = new StringBuilder("[");
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(list.get(i));
//            if (i +1 != list.size()){
//                sb.append(",");
//            }
//        }
//
//        sb.append("]");
//        return sb.toString();
    }
    void doSerialize(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(spliter);

        }else {
            sb.append(root.val).append(spliter);
            doSerialize(root.left,sb);
            doSerialize(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
//        if(data.length() == 0 || data.length() == 2){
//            return null;
//        }
//        data =data.replaceFirst("\\[", "");
//        data = data.replaceFirst("\\]", "");
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(data.split(spliter)));

//        Integer integer = linkedList.pollFirst();
//        TreeNode root = new TreeNode(integer);
//        TreeNode current = root;
        return doDeserialize( linkedList);
//        return  root;
    }

    private TreeNode doDeserialize( LinkedList<String> linkedList) {
        String s = linkedList.pollFirst();
        if (s.equals(NULL)){
            return null;
        }
//        if (linkedList.isEmpty()){
//            return;
//        }

        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = doDeserialize(linkedList);
        root.right = doDeserialize(linkedList);
        return root;
//        Integer left = s;
//        if (left != null){
//            TreeNode leftNode = new TreeNode(left);
//            current.left = leftNode;
//            doDeserialize(current.left, linkedList);
//        }
//        Integer right = s;
//        if (right != null){
//            TreeNode rightNode = new TreeNode(right);
//            current.right = rightNode;
//            doDeserialize(current.right, linkedList);
//        }
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
