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
//        String[] keyWords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] keyWords = {"storage", "battery", "hover", "alexa", "waterproof", "solar"};
        String[] reviews = {"I wish my Kindle had even more storage",
                "I wish the battery life on my Kindle lasted 2 years", "I read in the bath and would enjoy a waterproof Kindle",
                "I want to take my Kindle into the hover. Waterproof please waterproof!", "It would be neat if my Kindle would hover on my desk when not in use",
                "How cool would it be if my Kindle charged in the sun via solar power?"};
        System.out.println(Arrays.toString(new TopKFreq().getFreq(reviews, keyWords, 2)));
    }
}
