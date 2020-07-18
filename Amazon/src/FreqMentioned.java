import java.util.*;

public class FreqMentioned {
    public static void main(String[] args) {
        String[] keyWords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = {"I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular."};
        System.out.println(Arrays.toString(new FreqMentioned().getFreq(reviews, keyWords, 2)));
    }

    private String[] getFreq(String[] reviews, String[] keyWords, int k) {
        Map<String,Integer> map = new HashMap<>();
        Set<String> keySet = new HashSet<>(Arrays.asList(keyWords));
        for(String review:reviews){
            Set<String> set = new HashSet<>();
            review = review.replaceAll("[^a-zA-Z0-9\\s]","");
            for(String word:review.split(" ")){
                word = word.toLowerCase();
                if(!set.contains(word) && keySet.contains(word)){
                    map.put(word,map.getOrDefault(word,0)+1);
                    set.add(word);
                }
            }
        }
        ArrayList<String>[] bucket = new ArrayList[reviews.length+1];
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            int value = entry.getValue();
            if(bucket[value]==null){
                bucket[value] = new ArrayList();
            }
            bucket[value].add(entry.getKey());
        }
        String[] result = new String[k];
        int index = 0;
        for(int i = bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(int j = 0;j<bucket[i].size();j++){
                    result[index++] = bucket[i].get(j);
                    k--;
                    if(k == 0){
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
