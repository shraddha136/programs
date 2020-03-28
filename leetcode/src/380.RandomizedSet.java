import java.util.*;

class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int indexOfVal = map.get(val);
        int valAtEnd = list.get(list.size() - 1);
        map.put(valAtEnd, indexOfVal);
        map.remove(val);
        list.set(indexOfVal, valAtEnd);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.remove(0);
        rs.remove(0);
        rs.insert(0);
        rs.getRandom();
        rs.remove(0);
        rs.insert(0);

    }
}
