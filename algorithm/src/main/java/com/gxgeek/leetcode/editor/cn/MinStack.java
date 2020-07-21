package com.gxgeek.leetcode.editor.cn;

public class MinStack {
    /** initialize your data structure here. */
    private ListNode last;
    public MinStack() {

    }

    public void push(int x) {
        if(last == null){
            last = new ListNode(x,x);
        }else{
            last.next = new ListNode(x,last.currentMin);
            last.next.prev = last;
            last = last.next;
        }
    }

    public void pop() {
        last = last.prev;
    }

    public int top() {
        return last.val;
    }

    public int getMin() {
        return last == null ? 0 : last.currentMin;
    }


    public  class ListNode{
        public int currentMin;
        public int val;
        public ListNode next;
        public ListNode prev;
        public ListNode(int val,int lastMin){
            this.val = val;
            this.currentMin = Math.min(val,lastMin);
        }



    }

}
