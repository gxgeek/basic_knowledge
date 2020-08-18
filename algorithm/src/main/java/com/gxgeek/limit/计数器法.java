package com.gxgeek.limit;

public class 计数器法 {
    int maxQps=100;
    int count;
    long timeStamp= System.currentTimeMillis();
    long interval=1000;

    public synchronized boolean grant(){
        long now=System.currentTimeMillis();
        if(now < timeStamp+interval){
            count++;
            return count<maxQps;
        }else{
            timeStamp=now;
            count=1;
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
