import javafx.util.Pair;

import java.util.*;

public class HappyString {
//    public String longestDiverseString(int a, int b, int c) {
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('a', 0);
//        map.put('b', 0);
//        map.put('c', 0);
//        PriorityQueue<Pair<Character, Integer>> maxHeap = new PriorityQueue<>((x, y) -> (x.getValue().equals(y.getValue()) ?x.getKey().compareTo(y.getKey()):y.getValue() - x.getValue()));
//        if (a > 0) {
//            maxHeap.offer(new Pair<>('a', a));
//        }
//        if (b > 0) {
//            maxHeap.offer(new Pair<>('b', b));
//        }
//        if (c > 0) {
//            maxHeap.offer(new Pair<>('c', c));
//        }
//        Queue<Pair<Character, Integer>> queue = new LinkedList<>();
//        StringBuilder result = new StringBuilder();
//
//        while (!maxHeap.isEmpty()) {
//            Pair<Character, Integer> current = maxHeap.poll();
//            char currChar = current.getKey();
//
//            result.append(currChar);
//            map.put(currChar, map.get(currChar) + 1);
//
//            if (!queue.isEmpty()) {
//                if (map.get(queue.peek().getKey()) == 0) {
//                    maxHeap.offer(queue.poll());
//                }
//            }
//            if (map.get(current.getKey()) == 2) {
//                queue.offer(new Pair<>(currChar, current.getValue() - 1));
//                map.put(currChar, 0);
//            } else if (current.getValue() - 1 > 0) {
//                maxHeap.offer(new Pair<>(currChar, current.getValue() - 1));
//            }
//
//
//        }
//        return result.toString();
//    }
static public String longestDiverseString(int a, int b, int c) {

    StringBuilder builder = new StringBuilder();
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
            (count1, count2) -> Integer.compare(count2.count, count1.count));

    if (a > 0)
        pq.add(new Pair('a', a));
    if (b > 0)
        pq.add(new Pair('b', b));
    if (c > 0)
        pq.add(new Pair('c', c));

    while (pq.size() > 1) {

        Pair pair_one = pq.poll();
        if (pair_one.count >= 2) {
            builder.append(pair_one.ch);
            builder.append(pair_one.ch);
            pair_one.count -= 2;
        } else {
            builder.append(pair_one.ch);
            pair_one.count -= 1;
        }

        Pair pair_two = pq.poll();
        if (pair_two.count >= 2 && pair_one.count < pair_two.count) {
            builder.append(pair_two.ch);
            builder.append(pair_two.ch);
            pair_two.count -= 2;
        } else {
            builder.append(pair_two.ch);
            pair_two.count -= 1;
        }

        if (pair_one.count > 0)
            pq.add(pair_one);
        if (pair_two.count > 0)
            pq.add(pair_two);
    }

    if (!pq.isEmpty()) {
        if (builder.charAt(builder.length() - 1) != pq.peek().ch) {
            if (pq.peek().count >= 2) {
                builder.append(pq.peek().ch);
                builder.append(pq.peek().ch);
            } else {
                builder.append(pq.peek().ch);
            }
        }
    }
    return builder.toString();
}

    static class Pair {
        public Character ch;
        int count;

        public Pair(Character ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new HappyString().longestDiverseString(1, 0, 3));
        System.out.println(new HappyString().longestDiverseString(1, 1, 7));
        System.out.println(new HappyString().longestDiverseString(2, 2, 1));
        System.out.println(new HappyString().longestDiverseString(7, 1, 0));
    }
}
