import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }

    Map<Integer, Node> map;
    int capacity;
    int maxSize = 0;
    Node head = new Node();
    Node tail = new Node();

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }

    private void deleteNode(Node node) {
        Node nodePrev = node.prev;
        Node nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
    }

    private void addNode(Node node) { //always add to head
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            if (maxSize == capacity) {
                Node tailNode = tail.prev;
                deleteNode(tailNode);
                map.remove(tailNode.key);
            } else {
                maxSize++;
            }
            node = new Node();
            node.key = key;
            node.val = value;
            addNode(node);
            map.put(key, node);
        } else {
            deleteNode(node);
            map.get(key).val = value;
            addNode(node);
        }
    }
}
