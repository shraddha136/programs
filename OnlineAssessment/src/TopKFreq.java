import java.util.*;

public class TopKFreq {
    Map<String, Integer> map;
    PriorityQueue<Map.Entry<String, Integer>> priorityQueue;

    public TopKFreq() {
        map = new HashMap<>();
        priorityQueue = new PriorityQueue<>((a, b) -> (a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()));
    }

    public String[] getFreq(String[] reviews, String[] keywords, int k) {
        Set<String> set = new HashSet<>(Arrays.asList(keywords));
        for (String review : reviews) {
            Set<String> currReview = new HashSet<>();
            for (String word : review.split(" ")) {
                if (set.contains(word.toLowerCase()) && !currReview.contains(word.toLowerCase())) {
                    map.put(word.toLowerCase(), map.getOrDefault(word.toLowerCase(), 0) + 1);
                    currReview.add(word.toLowerCase());
                }
            }
        }

        String[] result = new String[k];
//        priorityQueue.addAll(map.entrySet());
//        for (int i = 0; i < k; i++) {
//            result[i] = priorityQueue.poll().getKey();
//        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            priorityQueue.add(entry);
            if(priorityQueue.size()>k)
                priorityQueue.poll();
        }
        k--;
        while (!priorityQueue.isEmpty())
            result[k--] = priorityQueue.poll().getKey();
        return result;
    }

    public static void main(String[] args) {
        String[] keyWords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = {"I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular."};
        System.out.println(Arrays.toString(new TopKFreq().getFreq(reviews, keyWords, 2)));
    }
}
