import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> wordMap = new HashMap<>();
        return dfs(s, wordDict, wordMap);
    }

    private boolean dfs(String s, List<String> wordDict, Map<String, Boolean> wordMap) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordMap.containsKey(s)) {
            return wordMap.get(s);
        }
        for (int i = 0; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict)) {
                wordMap.put(s.substring(i), true);
                return true;
            }
        }
        wordMap.put(s, false);
        return false;
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();

        // initialize the valid values
        List<String> l = new ArrayList<String>();
        l.add("");
        validMap.put(s.length(), l);

        // generate solutions from the end
        for(int i = s.length() - 1; i >= 0; i--) {
            List<String> values = new ArrayList<String>();
            for(int j = i + 1; j <= s.length(); j++) {
                if (wordDict.contains(s.substring(i, j))) {
                    for(String word : validMap.get(j)) {
                        values.add(s.substring(i, j) + (word.isEmpty() ? "" : " ") + word);
                    }
                }
            }
            validMap.put(i, values);
        }
        return validMap.get(0);
    }

    public static void main(String[] args) {
//        System.out.println(new WordBreak().wordBreak2("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(new WordBreak().wordBreak2("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new WordBreak().wordBreak2("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
