//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4670 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：两数相加
////给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4670 👎 0

import java.util.LinkedList;

public class GX_2_AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new GX_2_AddTwoNumbers().new Solution();
        // TO TEST
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        solution.addTwoNumbers(listNode, listNode2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> deque1 = new LinkedList<>();
        while(l1 != null){
            deque1.add(l1.val);
            l1 = l1.next;
        }

        LinkedList<Integer> deque2 = new LinkedList<>();
        while(l2 != null){
            deque2.add(l2.val);
            l2 = l2.next;
        }
        int intl1 = getInt(deque1);

        int intl2 = getInt(deque2);
        int total = intl1 + intl2;
        StringBuilder sb = new StringBuilder();
        sb.append(total);
        sb.reverse();
        String tRes = sb.toString();

        ListNode dummy =new ListNode(-1);
        ListNode current = dummy;

        for (int i = 0; i < tRes.length(); i++) {
            current.next = new ListNode(tRes.charAt(i)-'0');
            current = current.next;
        }

        return dummy.next;

    }

    private int getInt(LinkedList<Integer> deque1) {
        StringBuilder intl1Str  = new StringBuilder();
        while(!deque1.isEmpty()){
            intl1Str.append(deque1.pop());
        }
        return  Integer.parseInt(intl1Str.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
