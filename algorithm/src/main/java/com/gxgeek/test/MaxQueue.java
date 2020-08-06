package com.gxgeek.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxQueue {
    Deque<Integer> deque = new LinkedList<>();
    Deque<Integer> maxDeque = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        return !deque.isEmpty()  ? -1 : maxDeque.peekFirst();
    }

    public void push_back(int value) {
        deque.addLast(value);
        while(!maxDeque.isEmpty() && maxDeque.peekLast() < value){
            maxDeque.removeLast();
        }
        maxDeque.addLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) return -1;
        int value = deque.pop();
        if (maxDeque.peekFirst() == value) maxDeque.pop();
        return value;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());

    }

}
