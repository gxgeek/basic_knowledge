package com.gxgeek.test;

import java.util.HashMap;

public class LruCacheTest {
    private static int MAX_SIZE;
    private HashMap<Integer,Entry> hashMap;
    private Entry first;
    private Entry last;

    public LruCacheTest(Integer capacity) {
        MAX_SIZE = capacity;
        hashMap = new HashMap();
    }

    public void put(Integer key, Integer value){
        Entry entry = getEntry(key);
        if (entry == null){
            if (hashMap.size() >= MAX_SIZE){
                removeLast();
            }

            entry = new Entry();
            entry.key = key;
        }
        entry.value = value;
        moveToFirest(entry);
        hashMap.put(key, entry);
    }
    private void moveToFirest(Entry entry){
        if(entry == first){
            return;
        }
        if (entry.prev != null){
            entry.prev.next = entry.next;
        }
        if (entry.next != null){
            entry.next.prev = entry.prev;
        }
        // 判断头尾节点
        if (last == entry){
            last = entry.prev;
        }


        if (first == null && last == null){
            first = last = entry;
            return;
        }
        Entry oldFirst = first;
        oldFirst.prev = entry;
        entry.prev = null;
        entry.next = oldFirst;
        first = entry;
        return;
    }

    private void removeLast(){
        if (last != null){
            Entry oldLast = last;
            Entry newLast = last.prev;
            if (newLast == null){
                first = last = null;
            }else {
                newLast.next = null;
                last = newLast;
            }
            hashMap.remove(oldLast.key);
        }
    }

    private Entry getEntry(Integer key){
        return hashMap.get(key);
    }

    public Integer get(Integer key){
        Entry entry = getEntry(key);
        if (entry != null){
            moveToFirest(entry);
            return entry.value;
        }
        return -1;
    }

    public void remove(Integer key){
        Entry entry = getEntry(key);
        if (entry != null) {
            if (entry.prev != null){
                entry.prev.next = entry.next;
            }
            if (entry.next != null){
                entry.next.prev = entry.prev;
            }
            if (entry == first){
                first = first.next;
                if (first != null){
                    first.prev = null;
                }
            }
            if (entry == last){
                last = last.prev;
                if (last != null){
                    last.next = null;
                }
            }
            if (first == null || last == null){
                first = last = null;
            }
            hashMap.remove(entry.key);
        }
    }

    class Entry{
        private Integer key;
        private Integer value;
        private Entry prev;
        private Entry next;

        public Entry() {
        }
    }
}
