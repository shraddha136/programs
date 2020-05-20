//import java.util.*;
//
//public class WordLadder {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> set = new HashSet<>(wordList);
//
//        if (!set.contains(endWord))
//            return 0;
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        int level = 1;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int s = 0; s < size; s++) {
//                String curr = queue.poll();
//
//                //check all transformations
//                char[] currWord = curr.toCharArray();
//                for (int j = 0; j < currWord.length; j++) {
//                    char og = currWord[j];
//                    for (char c = 'a';c<='z';c++) {
//                        currWord[j] = c;
//                        String newWord = String.valueOf(currWord);
//                        if (newWord.equals(curr))
//                            continue;
//                        if (newWord.equals(endWord))
//                            return level + 1;
//                        if (set.contains(newWord)) {
//                            System.out.println(newWord);
//                            queue.offer(newWord);
//                            set.remove(newWord);
//                        }
//                    }
//                    currWord[j] = og;
//                }
//            }
//            level++;
//        }
//
//        return 0;

import java.util.*;

public class WordLadder {
    public class node {
        String word;
        int len;

        public node(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }

    public boolean isAdj(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        if (count == 1)
            return true;
        return false;
    }

    // Function to return the length of the shortest
// chain from 'beginWord' to 'endWord'
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {

	/* q1 is used to traverse the graph from beginWord
		and q2 is used to traverse the graph from endWord.
		vis1 and vis2 are used to keep track of the
		visited states from respective directions */
        Queue<node> q1 = new LinkedList<>();
        Queue<node> q2 = new LinkedList<>();
        HashMap<String, Integer> vis1 = new HashMap<>();
        HashMap<String, Integer> vis2 = new HashMap<>();

        node start = new node(beginWord, 1);
        node end = new node(endWord, 1);

        vis1.put(beginWord, 1);
        q1.add(start);
        vis2.put(endWord, 1);
        q2.add(end);

        while (q1.size() > 0 && q2.size() > 0) {

            // Fetch the current node
            // from the source queue
            node curr1 = q1.remove();

            // Fetch the current node from
            // the destination queue
            node curr2 = q2.remove();

            // Check all the neighbors of curr1
            for (int i = 0; i < wordList.size(); i++) {

                // If any one of them is adjacent to curr1
                // and is not present in vis1
                // then push it in the queue
                if (isAdj(curr1.word, wordList.get(i)) &&
                        vis1.containsKey(wordList.get(i)) == false) {

                    node temp = new node(wordList.get(i),
                            curr1.len + 1);
                    q1.add(temp);
                    vis1.put(wordList.get(i), curr1.len + 1);

                    // If temp is the destination node
                    // then return the answer
                    if (temp.word.equals(endWord)) {
                        return temp.len;
                    }

                    // If temp is present in vis2 i.e. distance from
                    // temp and the destination is already calculated
                    if (vis2.containsKey(temp.word)) {
                        return temp.len + vis2.get(temp.word) - 1;
                    }
                }
            }

            // Check all the neighbors of curr2
            for (int i = 0; i < wordList.size(); i++) {

                // If any one of them is adjacent to curr2
                // and is not present in vis1 then push it in the queue.
                if (isAdj(curr2.word, wordList.get(i)) &&
                        vis2.containsKey(wordList.get(i)) == false) {

                    node temp = new node(wordList.get(i),
                            curr2.len + 1);
                    q2.add(temp);
                    vis2.put(wordList.get(i), curr2.len + 1);

                    // If temp is the destination node
                    // then return the answer
                    if (temp.word.equals(beginWord)) {
                        return temp.len;
                    }

                    // If temp is present in vis1 i.e. distance from
                    // temp and the source is already calculated
                    if (vis1.containsKey(temp.word)) {
                        return temp.len + vis1.get(temp.word) - 1;
                    }
                }
            }
        }
        return 0;
    }

    // Driver code
    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}

// This code is contributed by Sambhav Jain

//    }
//
//
//            }
