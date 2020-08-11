import java.util.*;


class WordLadder {
    class Node {
        String word;
        int step;

        Node(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Node> firstQ = new ArrayDeque<>();
        Queue<Node> secondQ = new ArrayDeque<>();

        Map<String, Integer> start = new HashMap<>();
        Map<String, Integer> end = new HashMap<>();

        firstQ.offer(new Node(beginWord, 1));
        secondQ.offer(new Node(endWord, 1));

        start.put(beginWord, 1);
        end.put(endWord, 1);

        while (!firstQ.isEmpty() && !secondQ.isEmpty()) {
            Node one = firstQ.poll();
            Node two = secondQ.poll();

            for (String word : wordList) {
                if (isAdj(one.word, word) && !start.containsKey(word)) {
                    firstQ.offer(new Node(word, one.step + 1));
                    start.put(word, one.step + 1);

                    if (word.equals(endWord)) {
                        return start.get(word);
                    }
                    if (end.containsKey(word)) {
                        return start.get(word) + end.get(word) - 1;
                    }
                }
            }
            for (String word : wordList) {
                if (isAdj(two.word, word) && !end.containsKey(word)) {
                    secondQ.offer(new Node(word, two.step + 1));
                    end.put(word, two.step + 1);

                    if (word.equals(endWord)) {
                        return end.get(word);
                    }
                    if (start.containsKey(word)) {
                        return start.get(word) + end.get(word) - 1;
                    }
                }
            }
        }
        return 0;
    }

    private boolean isAdj(String a, String b) {
        int diff = 0;
        int i = 0;
        while (i < a.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            i++;
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
    }
}