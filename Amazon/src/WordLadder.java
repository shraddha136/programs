import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int len = 0;
        while (!queue.isEmpty()) {
            String currWord = queue.poll();
            for (int i = 0; i < currWord.length(); i++) {
                String tempWord = currWord;
                char atI = currWord.charAt(i);
                for (int j = 0; j < 26; j++) {
                    tempWord = tempWord.substring(0, i) + (char) (j + 'a') + tempWord.substring(i + 1);
                    if (wordList.contains(tempWord) && diff(tempWord, currWord)) {
                        wordList.remove(tempWord);
                        queue.offer(tempWord);
                    }
                    if (tempWord.equals(endWord)) {
                        return len + 1;
                    }
                }
            }
            len++;
        }
        return len;
    }

    private boolean diff(String word1, String word2) {
        int dif = 0;
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) != word2.charAt(j)) {
                dif++;
            }
            i++;
            j++;
        }
        return dif == 1;
    }

    public static void main(String[] args) {
        String[] l = {"a","b","c"};
//        String[] l = {"hot","dot","dog","lot","log","cog"};
        System.out.println(new WordLadder().ladderLength("a","c",new ArrayList<>(Arrays.asList(l))));
    }
}

