import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ReArrangeString {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        //count of each char
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        Map.Entry<Character, Integer> prev = null;
        maxHeap.addAll(map.entrySet());
        StringBuilder s = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> curr = maxHeap.poll();
            if (prev != null && prev.getValue() > 0)
                maxHeap.offer(prev);
            s.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);
            prev = curr;
        }
        return s.length() == S.length() ? s.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + new ReArrangeString().reorganizeString("aappp"));
        System.out.println("Rearranged string: " + new ReArrangeString().reorganizeString("Programming"));
        System.out.println("Rearranged string: " + new ReArrangeString().reorganizeString("aapa"));    }
}
