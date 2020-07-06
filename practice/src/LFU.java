import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class LFUCache {
    class Node {
        int key;
        int value;
        int count;

        public Node(int key, int value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    PriorityQueue<Node> pq;
    Map<Integer, Node> map;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        pq = new PriorityQueue<>((a, b) -> (a.count - b.count));
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        map.get(key).count += 1;
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                node = pq.poll();
                map.remove(node.key);
            }
            node = new Node(key, value, 1);
            map.put(key, node);
            pq.offer(node);

        } else {
            node.value = value;
            node.count += 1;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */