import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> (a.getValue().equals(b.getValue()) ? a.getKey() - b.getKey() : b.getValue() - a.getValue()));
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            priorityQueue.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!priorityQueue.isEmpty()){
            Map.Entry<Character, Integer> entry = priorityQueue.poll();
            int count = entry.getValue();
            char c = entry.getKey();
            for(int i = 0;i<count;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(new FrequencySort().frequencySort(s));
        System.out.println(new FrequencySort().frequencySort("cccaaa"));
        System.out.println(new FrequencySort().frequencySort("Aabb"));
    }
}
