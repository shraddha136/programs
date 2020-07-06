import java.util.*;

public class Occur {

    public static long[] solution(long[] numbers) {
        // Type your solution here
        if (numbers.length == 0) {
            return new long[0];
        }
        Map<Long, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Math.toIntExact((a.getValue().equals(b.getValue()) ? a.getKey() - b.getKey() : a.getValue() - b.getValue())));
        for (long num : numbers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Long,Integer> entry:map.entrySet()){
            pq.offer(entry);
        }
        int min = pq.peek().getValue();
        List<Long> list = new ArrayList<>();
        while (!pq.isEmpty() && pq.peek().getValue() == min) {
            list.add(pq.poll().getKey());
        }
        long[] result = new long[list.size()];
        int i = 0;
        for (long n : list) {
            result[i++] = n;

        }
        return result;
    }

    public static void main(String[] args) {
        long[] r = {13, 14, 124, 655, 12, 99, 14, 12, 14, 14, 14, 99, 13, 14, 88, 123, 455, 6, 0, 12, 99, 78, 29, 30, 55, 565, 9999, 1, 1, 1, 1, 1, -4, 30, 189, 992, 123, 44, 5, 1, 9, 7, 22, 12, 88, 24, 66, 6, 21, 4, 1, 9, 55, 565, 9999, 1, 1, 1, 1, 1, -4, 30, 189, 992, 123, 44, 5, 1, 9, 7, 22, 12, 88, 24, 66, 6, 21, 4, 1, 9, 55, 565, 9999, 1, 1, 1, 1, 1, -4, 30, 189, 992, 123, 44, 5, 1, 9, 7, 22, 12, 88, 24, 66, 6, 21, 4, 1, 9};
        System.out.println(Arrays.toString(solution(r)));
    }
}
