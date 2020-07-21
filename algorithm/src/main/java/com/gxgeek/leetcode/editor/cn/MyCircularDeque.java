package com.gxgeek.leetcode.editor.cn;

import java.util.Stack;

public class MyCircularDeque {
    Stack<Integer> one = new Stack<>(); //顺序
    Stack<Integer> two = new Stack<>(); //逆序
    int size = 0;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        ontToSecond();
        two.push(value);
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }

        secondToOne();
        one.push(value);
        return true;
    }

    private void ontToSecond(){
        while(!one.empty()){
            two.push(one.pop());
        }
    }
    private void secondToOne(){
        while(!two.empty()){
            one.push(two.pop());
        }
    }



    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }

        ontToSecond();
        two.pop();
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        secondToOne();
        one.pop();
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        ontToSecond();
        return two.peek();
    }

    /** Get the last item from the deque. */
    public int getRear() {
        secondToOne();
        return one.peek();
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        int reSize = one.size() == 0? two.size():one.size();
        return reSize == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        int reSize = one.size() == 0? two.size():one.size();
        return  reSize >= size;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));;			        // 返回 true
        System.out.println(circularDeque.insertLast(2));;			        // 返回 true
        System.out.println(circularDeque.insertFront(3));;			        // 返回 true
        System.out.println(circularDeque.insertFront(4));;			        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());;  				// 返回 2
        System.out.println(circularDeque.isFull());;				        // 返回 true
        System.out.println(circularDeque.deleteLast());;			        // 返回 true
        System.out.println(circularDeque.insertFront(4));;			        // 返回 true
        System.out.println(circularDeque.getFront());;				// 返回 4


    }

}
