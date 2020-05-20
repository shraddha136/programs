//import java.util.HashMap;
//import java.util.Map;
//
//class LRUCache {
//
//    class Node {
//        int key;
//        int val;
//        Node next;
//        Node prev;
//    }
//
//    Map<Integer, Node> map;
//    int capacity;
//    int maxSize = 0;
//    Node head = new Node();
//    Node tail = new Node();
//
//    LRUCache(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<>();
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            Node node = map.get(key);
//            deleteNode(node);
//            addNode(node);
//            return node.val;
//        }
//        return -1;
//    }
//
//    private void deleteNode(Node node) {
//        Node nodePrev = node.prev;
//        Node nodeNext = node.next;
//        nodePrev.next = nodeNext;
//        nodeNext.prev = nodePrev;
//    }
//
//    private void addNode(Node node) { //always add to head
//        Node headNext = head.next;
//        head.next = node;
//        node.next = headNext;
//        node.prev = head;
//        headNext.prev = node;
//    }
//
//    public void put(int key, int value) {
//        Node node = map.get(key);
//
//        if (node == null) {
//            if (maxSize == capacity) {
//                Node tailNode = tail.prev;
//                deleteNode(tailNode);
//                map.remove(tailNode.key);
//            } else {
//                maxSize++;
//            }
//            node = new Node();
//            node.key = key;
//            node.val = value;
//            addNode(node);
//            map.put(key, node);
//        } else {
//            deleteNode(node);
//            map.get(key).val = value;
//            addNode(node);
//        }
//    }
//}


import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer,Node> map;
    int maxSize;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        this.map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node currNode = map.get(key);
        if(currNode == null){
            return -1;
        }
        deleteNode(currNode);
        addNode(currNode);
        return currNode.value;
    }

    public void put(int key, int value) {
        Node currNode = map.get(key);
        if(currNode == null){
            if(map.size() == maxSize){
                Node currTail = tail.prev;
                int currKey = currTail.key;
                deleteNode(currTail);
                map.remove(currKey);
            }
            currNode = new Node();
            currNode.key = key;
            currNode.value = value;
            map.put(key,currNode);
            addNode(currNode);
        }else{
            deleteNode(currNode);
            currNode.value = value;
            map.put(key,currNode);
        }
    }

    private void addNode(Node node){
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;

    }

    private void deleteNode(Node node){
        if(node == tail){
            Node tailPrev = tail.prev;
            tail.prev.next = null;
            tail = tailPrev;
        }
        else{
            Node nodeNext = node.next;
            Node nodePrev = node.prev;
            node.prev.next = nodeNext;
            node.next.prev = nodePrev;
        }
    }

    class Node{
        int key;
        int value;
        Node next;
        Node prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */