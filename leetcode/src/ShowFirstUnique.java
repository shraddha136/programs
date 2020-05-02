import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ShowFirstUnique {
    Map<Integer,Integer> map;
    PriorityQueue<Map.Entry<Integer,Integer>> queue;
    public ShowFirstUnique(int[] nums) {
        map = new LinkedHashMap<>();
        for(int num:nums)
            add(num);
    }

    public int showFirstUnique() {
        if(map.isEmpty())
            return -1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return -1;
    }

    public void add(int value) {
        if(map.containsKey(value)){
            int count = map.get(value);
            map.remove(value);
            map.put(value,count+1);
        }else{
            map.put(value,1);
        }
    }

    public static void main(String[] args) {
        ShowFirstUnique showFirstUnique = new ShowFirstUnique(new int[]{809});
        System.out.println(showFirstUnique.showFirstUnique());
        showFirstUnique.add(809);
        System.out.println(showFirstUnique.showFirstUnique());
    }
}
