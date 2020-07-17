import java.util.*;

public class ConcatWords {

    //cmapcapmap
    // map, cap
    Map<String,Integer> dictCount;
    Map<String,Integer> seenCount;
    public List<Integer> getConcatCount(String s, List<String> words){
        dictCount = getCount(words);
        List<Integer> result = new ArrayList<>();
        int len = 3;

        for(int start = 0;start <= s.length()-words.size()*len;start++){
            seenCount = new HashMap<>();
            for(int end = 0;end<words.size();end++){
                int wordIndex = start + end * len;
                String word = s.substring(wordIndex,wordIndex + len);
                if(!dictCount.containsKey(word)){
                    break;
                }
                seenCount.put(word,seenCount.getOrDefault(word,0)+1);
                if(seenCount.get(word)>dictCount.get(word)){
                    break;
                }
                if(end + 1 == words.size()){
                    result.add(start);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ConcatWords().getConcatCount("cmapcapmap",new ArrayList<>(Arrays.asList("map", "cap"))));
    }

    private Map<String, Integer> getCount(List<String> words) {
        dictCount = new HashMap<>();
        for(String word:words){
            dictCount.put(word,dictCount.getOrDefault(word,0)+1);
        }
        return dictCount;
    }
}
