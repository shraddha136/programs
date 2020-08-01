import java.util.*;

class LFUCache {

    int capacity;
    int minCount;
    Map<Integer,Integer> keyToVal;
    Map<Integer,Integer> keyToCount;
    Map<Integer, LinkedHashSet<Integer>> countToVal;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minCount = -1;
        keyToVal = new HashMap<>();
        keyToCount = new HashMap<>();
        countToVal = new HashMap<>();
    }

    public int get(int key) {
        if(!keyToVal.containsKey(key)){
            return -1;
        }
        int count = keyToCount.remove(key);
        keyToCount.put(key,count+1);
        countToVal.get(count).remove(key);

        if(count == minCount && countToVal.get(count).size()==0){
            minCount++;
        }
        LinkedHashSet<Integer> LinkedHashSet = new LinkedHashSet<>();
        if(countToVal.containsKey(count+1)){
            LinkedHashSet = countToVal.get(count+1);
        }
        LinkedHashSet.add(key);
        countToVal.put(count+1,LinkedHashSet);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            get(key);
            return;
        }else{
            if(keyToVal.size() == capacity){
                int toEvict = countToVal.get(minCount).iterator().next();
                evict(toEvict);
            }
            keyToVal.put(key,value);
            keyToCount.put(key,keyToCount.getOrDefault(key,0)+1);
        }
        int count = keyToCount.get(key);
        LinkedHashSet<Integer> LinkedHashSet = new LinkedHashSet<>();
        if(countToVal.containsKey(count)){
            LinkedHashSet = countToVal.get(count);
        }
        LinkedHashSet.add(key);
        minCount=1;
        keyToCount.put(key,count);
        countToVal.put(count,LinkedHashSet);
    }

    private void evict(int toEvict) {
        int count = keyToCount.get(toEvict);
        countToVal.get(count).remove(toEvict);
        keyToVal.remove(toEvict);
        keyToCount.remove(toEvict);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(0, 0);
//        cache.put(2, 2);
        cache.get(0);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.get(3);       // returns 3.
//        cache.put(4, 4);    // evicts key 1.
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */