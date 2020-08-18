package com.gxgeek.limit;

public class 漏桶算法 {
    long timeStamp=System.currentTimeMillis();//上一次调用grant的时间
    int bucketSize=100;//桶大小
    int rate=10;//每ms流出多少请求
    int count;//目前的水量

    public synchronized boolean grant(){
        long now = System.currentTimeMillis();
        if(now>timeStamp){
            count = (int) Math.max(0,count-(now-timeStamp)*rate);
            timeStamp = now;
        }

        if(count+1<=bucketSize){
            count++;
            return true;
        }else{
            return false;
        }
    }

}
