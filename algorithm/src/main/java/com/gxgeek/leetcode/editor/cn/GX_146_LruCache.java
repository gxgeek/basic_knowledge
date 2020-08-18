//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 804 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：LRU缓存机制
////运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 804 👎 0

import java.util.HashMap;
import java.util.Map;

public class GX_146_LruCache{
    public static void main(String[] args) {
        GX_146_LruCache gx_146_lruCache = new GX_146_LruCache();
//        Solution solution = (Solution) gx_146_lruCache;
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    Map<Integer, Entry> map = new HashMap<>();
    int MAX_SIZE;
    Entry last;
    Entry first;
    public LRUCache(int capacity) {
        MAX_SIZE = capacity;
    }
    
    public int get(int key) {
        Entry entry = getEntry(key);
        if (entry == null){
            return  -1;
        }
        moveFirst(entry);
        return entry.val;
    }

    private void moveFirst(Entry entry) {
        if (entry == first) return;
        if (entry.prev != null) entry.prev.next = entry.next;
        if (entry.next != null) entry.next.prev = entry.prev;
        if (entry == last){
            last = entry.prev;
        }

        if (first == null  || last == null){
            first = last = entry;
        }else{
            Entry oldFirst = this.first;
            oldFirst.prev = entry;
            entry.next = oldFirst;
            entry.prev = null;
            first = entry;
        }
    }

    public void put(int key, int value) {
        Entry entry = getEntry(key);
        if (entry == null){
            if (map.size() == MAX_SIZE){
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.val = value;
        moveFirst(entry);
        map.put(entry.key, entry);
    }

    private void addLast(Entry entry) {
        if (last == entry)return;
        if (entry.prev != null ) entry.prev.next = entry.next;
        if (entry.next != null ) entry.next.prev = entry.prev;
        if (entry == first){
            first = entry.next;
            first.prev = null;
        }
        if (first == null  || last == null){
            first = last = entry;
        }else{
            Entry oldLast = this.last;
            oldLast.next = entry;
            entry.prev = oldLast;
            last = entry;
        }
        map.put(entry.key, entry);
    }

    private void removeLast() {
        if (last != null){
            Entry oldLast = this.last;
            Entry newLast = oldLast.prev;
            if (newLast == null){
                first = last = null;
            }else {
                newLast.next = null;
                last = newLast;

            }
            map.remove(oldLast.key);
        }
    }

        Entry getEntry(int key){
        return map.get(key);
    }


    class Entry{
        Entry prev;
        Entry next;
        Integer val;
        Integer key;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
