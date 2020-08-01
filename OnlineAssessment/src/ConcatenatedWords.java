import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {

    class TrieNode {
        TrieNode[] chars;
        boolean isEnd;

        TrieNode() {
            chars = new TrieNode[26];
            this.isEnd = false;
        }
    }

    class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (current.chars[index] == null) {
                    current.chars[index] = new TrieNode();
                }
                current = current.chars[index];
            }
            current.isEnd = true;
        }

        public boolean contains(String word, int index, int count, TrieNode root) {
            TrieNode current = root;
            for (int i = index; i < word.length(); i++) {
                int cIndex = word.charAt(i) - 'a';
                if (current.chars[cIndex] == null) {
                    return false;
                }
                if (current.chars[cIndex].isEnd) {
                    if (index == word.length() - 1) {
                        return count >= 1;
                    }
                    if (contains(word, i + 1, count + 1, root)) {
                        return true;
                    }

                }

                current = current.chars[cIndex];

            }
            return current.isEnd && count >= 1;
        }


        public boolean containsPrefix(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (current.chars[index] == null) {
                    return false;
                }
                current = current.chars[index];
            }
            return true;
        }
    }

    private Trie trie;

    ConcatenatedWords() {
        trie = new Trie();
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        for (String word : words) {
            trie.insert(word);
        }

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (trie.contains(word, 0, 0, trie.root)) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(words));
    }

}
