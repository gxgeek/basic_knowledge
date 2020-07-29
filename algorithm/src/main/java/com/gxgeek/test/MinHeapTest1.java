package com.gxgeek.test;

public class MinHeapTest1 {

    private int[] heap = new int[16];

    int size = 0;

    public void insert(int i) {
        if (size == 0) {
            heap[size++] = i;
        } else {
            heap[size++] = i;
            fixUP();
        }
    }

    public int poll(int i) {
        int minValue = heap[0];
        heap[0] = heap[size - 1];
        heap[--size] = 0;
        fixDown();
        return minValue;
    }

    private void fixDown() {
        int f = 0;
        int k;
        while ((k = 2 * f + 1) < size){
            if (k < size - 1){
                if (heap[k] > heap[k + 1]) k++;
            }
            if (heap[f] < heap[k]) {
                break;
            }
            int t = heap[f];
            heap[f] = heap[k];
            heap[k] = t;
            f = k;
        }
    }

    private void fixUP() {
        int end = size - 1;
        int f;
        while ((f = (end - 1) / 2) >= 0) {
            if (heap[f] < heap[end]) {
                break;
            }

            int t = heap[end];
            heap[end] = heap[f];
            heap[f] = t;
            end = f;
        }
    }
}
