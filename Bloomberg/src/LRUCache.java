import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node{
        int val;
        Node next;
        Node prev;
    }

    Map<Integer,Node> nodeMap;
    Node head;
    Node tail;
    int maxSize;
    public LRUCache(int capacity) {
        maxSize = capacity;
        nodeMap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null){
            return -1;
        }
        int val = node.val;
        removeFromList(node);
        addToHead(node);
        return val;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        //key does not exist
        if(node == null){
            //map full
            if(nodeMap.size()==maxSize){
                Node lastNode = tail.prev;
                nodeMap.remove(lastNode.val);
                removeFromList(lastNode);
            }// not full -> simply add to head and map
            Node newNode = new Node();
            newNode.val = value;
            addToHead(newNode);
            nodeMap.put(key,newNode);
        }else{//remove node from list and add to head and change the value
            removeFromList(node);
            node.val = value;
            addToHead(node);
            nodeMap.put(key,node);
        }
    }

    private void addToHead(Node node){
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }

    private void removeFromList(Node node){
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */