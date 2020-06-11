import java.util.*;

public class TopK {
    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        System.out.println(solve(k1, keywords1, reviews1));
        System.out.println(solve(k2, keywords2, reviews2));
    }

    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        List<String> result = new ArrayList<>();
        Map<String,Integer> wordCount = new HashMap<>();
        Set<String> keyWordSet = new HashSet<>(Arrays.asList(keywords));
        for(String review:reviews){
            Set<String> seenWord = new HashSet<>();
            for(String word:review.split(" ")){
                word = word.toLowerCase();
                if(keyWordSet.contains(word) && !seenWord.contains(word)){
                    seenWord.add(word);
                    wordCount.put(word,wordCount.getOrDefault(word,0)+1);
                }
            }
        }

        PriorityQueue<HashMap.Entry<String,Integer>> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b.getValue(),a.getValue()));
        for(Map.Entry<String,Integer> entry: wordCount.entrySet())
            maxHeap.offer(entry);

        for(int i = 0;i<k;i++){
            String word = maxHeap.poll().getKey();
            result.add(word);
        }

        return result;
    }
}
