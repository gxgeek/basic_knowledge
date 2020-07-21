package com.gxgeek.test;

public class LruTest {

    private Node first;
    private Node last;

    private Integer maxSize;
    private Integer currentSize = 0;


    public LruTest(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public void addLast(int val){
        if (currentSize.equals(maxSize)){
            cleanFirst();
        }
        Node node = new Node(val);
        Node oldLast = last;
        last = node;

        if (first == null){
            first = node;
        }else {
            oldLast.next = last;
        }
        currentSize ++;
    }

    private void cleanFirst() {
        Node oldFirst = first;
        Node next = first.next;
        first = next;
        oldFirst = null;
        currentSize--;
    }


    public static void main(String[] args) {
        LruTest lruTest = new LruTest(10);
        for (int i = 0; i < 10; i++) {
            lruTest.addLast(i);
        }
        lruTest.addLast(11);

    }

    class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
