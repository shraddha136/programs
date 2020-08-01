import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return tasks.length;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        int size = 0;
        while (!pq.isEmpty()) {
            List<Map.Entry<Character, Integer>> waiting = new ArrayList<>();
            int k = n + 1;
            while (k > 0 && !pq.isEmpty()) {
                size++;
                Map.Entry<Character, Integer> current = pq.poll();
                if (current.getValue() > 1) {
                    current.setValue(current.getValue() - 1);
                    waiting.add(current);
                }
                k--;
            }
            pq.addAll(waiting);
            if(!pq.isEmpty()){
                size += k;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        char[] a = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(new TaskScheduler().leastInterval(a, 2));
    }
}
