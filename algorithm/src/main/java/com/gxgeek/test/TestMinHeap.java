package com.gxgeek.test;

public class TestMinHeap {

    private int[] table = new int[16];

    private int size = 0;

    public void push(int val){
        if(size == 0){
            table[size++] = val;
            return;
        }else {
            table[size++] = val;
            fixUp();
        }

    }

    private void fixUp() {
        int j = size-1;
        int f;
        while ((f = (j-1)/2) >0){
            if (table[j] >= table[f]) {
                break;
            }
            int jVal = table[j];
            table[j] = table[f];
            table[f] = jVal;
            j = f;
        }
    }

    private int poll(){
        int popValue = table[0];
        table[0] = table[--size];
        table[size] = 0;

        fixDown();
        return popValue;


    }

    private void fixDown() {
        int f = 0;
        int j;
        while ((j=( 2*f +1))<size ){
            //判断右节点是否比节点小
            if (j+1<size && table[j]>table[j+1]){
                j++;
            }

            if (table[f]<=table[j]){
                break;
            }
            int fVal = table[f];
            table[f] = table[j];
            table[j] = fVal;
            f = j;
        }
    }

    public static void main(String[] args) {
        TestMinHeap testMinHeap = new TestMinHeap();
        testMinHeap.push(1);
        testMinHeap.push(5);
        testMinHeap.push(3);
        testMinHeap.push(2);
        testMinHeap.push(8);
        testMinHeap.push(10);
        int size = testMinHeap.size;
        for (int i = 0; i < size; i++) {
            System.out.println(testMinHeap.poll());
        }

    }
}
