package com.gxgeek;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruTest<K,V> extends LinkedHashMap<K,V> {
    private Integer cacheSize;


    public LruTest(Integer cacheSize) {
        super((int)Math.ceil(cacheSize/0.75)+1, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
