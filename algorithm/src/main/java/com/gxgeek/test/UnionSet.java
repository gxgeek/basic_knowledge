package com.gxgeek.test;

public class UnionSet {

    private int count;
    private int[] parent;

    public UnionSet(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p ){
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int q,int p ){
        int rooP = find(p);
        int rooQ = find(q);
        if (rooP == rooQ){
            return;
        }
        parent[rooP] = rooQ;
        count--;
    }

}
