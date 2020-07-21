//package com.gxgeek.test;
//
//import java.util.Arrays;
//
//public class HeapTest {
//
//
//    private int[] heap = new int[16];
//    int currentSize;
//
//    public void push(int item){
////        if (currentSize >=heap.length){
////            //扩容
////            heap = Arrays.copyOf(heap, currentSize << 2);
////        }
//        heap[currentSize++] = item;
//        siftUP();
//
//    }
//
//
//    private void siftUP() {
//        int last = currentSize - 1;
//        int parentIndex;
//
//        while ((parentIndex = (last-1)>>1)>=0){
//            if (heap[parentIndex] <= last){
//                break;
//            }
//
//            int parentValue = heap[parentIndex];
//            heap[parentIndex] = heap[last];
//            heap[last] = parentValue;
//            last = parentIndex;
//        }
////        return parentIndex;
//    }
//
//    public int poll(){
//        int top = heap[0];
//
//        heap[0] = heap[--currentSize];
//        //clean 数据
//        heap[currentSize] = 0;
//
//        siftDown(0);
//        return top;
//    }
//
//    private void siftDown(int start) {
//        int parant = 0;
//        int k;
//        for ((k = (parant<<1 +1)) >currentSize;;){
//
//        }
//    }
//
//    private void swap(int x, int y) {
//        int tmp = heap[x];
//        heap[x] = heap[y];
//        heap[y] = tmp;
//    }
//
//}
