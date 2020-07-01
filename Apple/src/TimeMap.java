import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {


    /** Initialize your data structure here. */
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> tree = map.get(key);
        Integer t = tree.floorKey(timestamp);
        return t != null ? tree.get(t) : "";

    }


    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("love", "high", 10);
        obj.set("love", "low", 20);
        System.out.println(obj.get("love", 5));
        System.out.println(obj.get("love", 10));
        System.out.println(obj.get("love", 15));
        System.out.println(obj.get("love", 20));
        System.out.println(obj.get("love", 25));
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */