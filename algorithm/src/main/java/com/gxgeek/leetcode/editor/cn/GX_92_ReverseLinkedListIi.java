//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 423 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：反转链表 II
public class GX_92_ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new GX_92_ReverseLinkedListIi().new Solution();
        ListNode a = new ListNode(1);
        a.next  = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        solution.reverseBetween(a, 2, 4);
        // TO TEST
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
//        确定prev节点
        for(int i = 1; i<m;i++){
            prev = prev.next;
        }
//        确定当前节点
        ListNode current = prev.next;
        for(int i = m;i<n;i++){
            ListNode next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
