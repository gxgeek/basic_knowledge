package com.gxgeek.test;

public class MinHeap001 {

    int[] heap = new int[16];

    int size = 0;
    public void insert(int value){
        heap[size++] = value;
        fixUp();
    }
    public int  popValue(){
        int popValue = heap[0];
        heap[0] = heap[size--];
        heap[size] = 0; //清空最后一个的数据
        fixDown();
        return popValue;
    }

    private void fixDown() {
        int f = 0;
        int j;
        while ((j = 2*f + 1) < size){
            if (j+1 < size  && heap[j] > heap[j+1]){
                j = j+1;
            }
            if (heap[f] < heap[j]) break;;
            int t = heap[f];
            heap[f] = heap[j];
            heap[j] = t;
            f = j;
        }
    }

    private int fixUp() {
        int j = size-1;
        int f;
        while ((f = (j-1)/2)>=0){
            if (heap[f] <= heap[j]) break;;

            int t = heap[f];
            heap[f] = heap[j];
            heap[j] = t;

            j = f;
        }
        return f;
    }
}
