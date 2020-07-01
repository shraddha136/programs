import java.util.ArrayList;
import java.util.List;

class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.addNode(word);
        }

        for (String word : words) {
            if (trie.findWord(word.toCharArray(), 0, 0, trie.root)) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] Input = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(Input));
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private int getIndex(char c) {
        return c - 'a';
    }

    public void addNode(String word) {
        if (word.length() == 0) {
            return;
        }
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = getIndex(word.charAt(i));
            if (current.letters[index] == null) {
                current.letters[index] = new TrieNode();
            }
            current = current.letters[index];
        }
        current.isEnd = true;
    }

    public boolean findWord(char[] word, int index, int count, TrieNode root) {
        TrieNode current = root;
        int len = word.length;
        for (int i = index; i < word.length; i++) {
            int idx = getIndex(word[i]);
            if (current.letters[idx] == null) {
                return false;
            }
            if (current.letters[idx].isEnd) {
                if (i == len - 1) {
                    return count >= 1;
                }
                if (findWord(word, i+1 , count + 1, root)) {
                    return true;
                }
            }
            current = current.letters[idx];
        }

        return current.isEnd && count >=1;
    }
}

class TrieNode {
    TrieNode[] letters;
    boolean isEnd;

    public TrieNode() {
        letters = new TrieNode[26];
        isEnd = false;
    }
}

// Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
