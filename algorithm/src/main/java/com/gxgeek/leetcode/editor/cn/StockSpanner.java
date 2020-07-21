//package com.gxgeek.leetcode.editor.cn;
//
//import java.util.*;
//
//public class StockSpanner {
//
//    Stack<Integer> prices, weights;
//
//    public StockSpanner() {
//        prices = new Stack();
//        weights = new Stack();
//        prices.empty()
//    }
//
//    public int next(int price) {
//        Deque<Integer> deque = new LinkedList<>)();
//        deque.pollFirst()
//        int w = 1;
//        Objects.equals()
//        while (!prices.isEmpty() && prices.peek() <= price) {
//            prices.pop();
//            w += weights.pop();
//        }
//
//        prices.push(price);
//        weights.push(w);
//        return w;
//    }
//
//    public static void main(String[] args) {
//        StockSpanner stockSpanner = new StockSpanner();
//        List list = new ArrayList();
//
//        list.add(11);
//        list.add(10);
//        list.add(12);
//        list.add(11);
//        list.add(11);
//
//        for (Object o : list) {
//
//            System.out.println(stockSpanner.next((Integer) o));;
//
//        }
//    }
//}
