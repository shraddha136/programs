import java.util.HashMap;
import java.util.*;

class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new LinkedList<>();
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int pos = map.get(val);
            int toReplace = list.get(list.size()-1);
            map.put(toReplace,pos);
            map.remove(val);
            list.set(pos,toReplace);

            list.remove(list.size()-1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return list.get((int)r.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        System.out.println(r.remove(0));
        System.out.println(r.remove(0));
        System.out.println(r.insert(0));
        System.out.println(r.getRandom());
        System.out.println(r.remove(0));
        System.out.println(r.insert(0));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */