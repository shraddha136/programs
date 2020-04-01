import java.util.*;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null)
            return memo[start];
        for (int end = start + 1; end <= s.length(); end++) {
            String curr = s.substring(start, end);
            if (wordDict.contains(curr)) {
                if (word_Break(s, wordDict, end, memo)) {
                    return memo[start] = true;
                }
            }
        }
        return memo[start] = false;
    }

    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDict.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length())
                            return true;
                    }
                }
                visited[start] = 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
//        String s = "catsandog";
//        List<String> wordDict = new LinkedList<>();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
        String s = "leetcode";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new WordBreak().wordBreakBFS(s, wordDict));
    }
}
