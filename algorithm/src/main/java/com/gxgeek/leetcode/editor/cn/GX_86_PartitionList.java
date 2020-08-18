//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 242 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：分隔链表
////给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 242 👎 0
	
public class GX_86_PartitionList{
    public static void main(String[] args) {
        Solution solution = new GX_86_PartitionList().new Solution();
        // TO TEST
//        [1,4,3,2,5,2]
//        3
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);
        solution.partition(node, 3);
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
    public ListNode partition(ListNode head, int x) {
        ListNode one = new ListNode(-1);
        ListNode tOne = one;
        ListNode two = new ListNode(-1);
        ListNode tTwo = two;
        while(head != null){
            if (head.val < x){
                tOne.next = head;
                tOne = tOne.next;
                head = head.next;
            }else{
                tTwo.next = head;
                tTwo = tTwo.next;
                head = head.next;
            }
        }

        tOne.next = two.next;
        return one.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
