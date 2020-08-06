package com.gxgeek.test;

import java.util.HashMap;
import java.util.Map;

public class LruCacheTest1 {
    Node first;
    Node last;
    Map<Integer, Node> map = new HashMap<>();
    int MAX_SIZE;

    public LruCacheTest1(int maxSize) {
        this.MAX_SIZE = maxSize;
    }

    public Integer get(Integer key){
        Node node = getNode(key);
        if (node != null){
            addNodeToFirst(node);
            return node.value;
        }
        return -1;

    }
    public void put(Integer key, Integer value){
        Node node = getNode(key);
        if (node == null){
            if (map.size() >= MAX_SIZE){
                removeLast();
            }
            node = new Node();
            node.key = key;
        }
        node.value = value;
        map.put(key, node);
        addNodeToFirst(node);
    }

    public void remove(Integer key){
        Node node = getNode(key);
        if (node == null)return;
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        if (node == first){
            first = node.next;
            if (first != null) first.prev = null;
        };
        if (node == last){
            last = node.prev;
            if (last != null) last.next = null;
        }
        if (last == null || first == null){
            last = first = null;
        }
        map.remove(key);
    }


    private void removeLast() {
        if(last != null){
            Node oldLast = this.last;
            Node prev = oldLast.prev;
            if (prev == null){
                first = last = null;
            }else {
                prev.next = null;

                last = oldLast.prev;

            }
            map.remove(oldLast.key);
        }
    }

    private void addNodeToFirst(Node node) {
        if (node == first) return;
        if (node == last) last = node.prev;
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        if (first == null && last == null){
            first = last = node;
        }else {
            Node oldFirst = this.first;
            oldFirst.prev = node;
            node.next = oldFirst;
            node.prev = null;
            first = node;
        }
    }

    public Node getNode(Integer key){
        return map.get(key);
    }




    class Node{
        private Integer key;
        private Integer value;
        private Node prev;
        private Node next;
    }
}
