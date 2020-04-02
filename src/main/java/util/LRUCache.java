package util;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private class DoubleLinkedList {
        private LRUNode head;
        private LRUNode tail;

        public DoubleLinkedList() {
            this.head = new LRUNode(null);
            this.tail = new LRUNode(null);
            head.next = tail;
            tail.prev = head;
        }
    }

    private class LRUNode {
        public LRUNode(DataNode dataNode) {
            this.dataNode = dataNode;
        }

        private DataNode dataNode;
        private LRUNode prev;
        private LRUNode next;
    }

    private class DataNode {
        public DataNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        private Integer val;
        private Integer key;
        private LRUNode lruNode;
    }

    private int capacity;
    private DoubleLinkedList lruList;
    private Map<Integer, DataNode> data = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lruList = new DoubleLinkedList();
    }

    public int get(int key) {
        DataNode dataNode = data.get(key);
        if (dataNode == null) {
            return -1;
        }
        LRUNode lruNode = dataNode.lruNode;

        lruNode.prev.next = lruNode.next;
        lruNode.next.prev = lruNode.prev;

        insertToHead(lruNode);

        return data.get(key).val;
    }

    public void put(int key, int value) {
        if (data.containsKey(key)) {
            DataNode dataNode = data.get(key);
            dataNode.val = value;
            LRUNode lruNode = dataNode.lruNode;

            lruNode.prev.next = lruNode.next;
            lruNode.next.prev = lruNode.prev;

            insertToHead(dataNode.lruNode);
        } else {
            if (data.size() == capacity) {
                doEvict();
            }

            DataNode dataNode = new DataNode(key, value);
            LRUNode lruNode = new LRUNode(dataNode);
            dataNode.lruNode = lruNode;
            insertToHead(lruNode);

            data.put(key, dataNode);
        }
    }

    private void insertToHead(LRUNode lruNode) {
        LRUNode fristElement = lruList.head.next;
        if (lruNode == fristElement) return;
        fristElement.prev = lruNode;
        lruList.head.next = lruNode;
        lruNode.prev = lruList.head;
        lruNode.next = fristElement;
    }

    private void doEvict() {
        LRUNode tailNode = lruList.tail.prev;
        tailNode.prev.next = tailNode.next;
        tailNode.next.prev = tailNode.prev;
        data.remove(tailNode.dataNode.key);
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        System.out.println(lruCache.get(3));
        lruCache.put(4,4);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

}