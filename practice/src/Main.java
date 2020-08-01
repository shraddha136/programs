import java.util.*;

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    int[] charMap;
    String word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
        this.charMap = new int[26];
        this.word = null;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    private int getCharIndex(char c) {
        return c - 'a';
    }

    public void insertWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode root = this.root;
        int[] counts = new int[26];
        for (char c : word.toCharArray()) {
            int index = getCharIndex(c);
            if (root.children[index] == null) {
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
            counts[index] += 1;
        }
        root.isWord = true;
        root.charMap = counts;
        root.word = word;
    }

    public List<TrieNode> searchAndGetPrefixes(char c, int[] charMap) {
        TrieNode root = this.root;
        List<TrieNode> results = new ArrayList<>();
        root = root.children[c - 'a'];
        if (root == null) {
            return results;
        }
        findPrefixes(root, results, charMap);
        return results;
    }

    public void findPrefixes(TrieNode root, List<TrieNode> results, int[] charMap) {
        if (root.isWord) {
            if (countMatches(charMap, root.charMap, root.word.length())) {
                results.add(root);
            }
        }
        for (int i = 0; i < 26; i++) {
            TrieNode child = root.children[i];
            if (child != null) {
                findPrefixes(child, results, charMap);
            }
        }
    }

    private boolean countMatches(int[] source, int[] nodeCharMap, int length) {
        if (nodeCharMap == null || nodeCharMap.length == 0) {
            return false;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (source[i] == nodeCharMap[i] && nodeCharMap[i] >= 1) {
                matches += 1;
            }
        }
        return matches == length;
    }
}

public class Main {
    public static List<String> getLongestValidWords(String[] dictionary, String letters) {
        if (dictionary == null || dictionary.length == 0) {
            return new ArrayList<>();
        }
        Trie trie = new Trie();
        int[] charMap = new int[26];
        for (char c : letters.toCharArray()) {
            charMap[c - 'a'] += 1;
        }
        List<String> words = new ArrayList<>();
        for (String word : dictionary) {
            trie.insertWord(word);
        }
        int maxLength = 0;
        for (char c : letters.toCharArray()) {
            List<TrieNode> prefixes = new ArrayList<>();
            prefixes = trie.searchAndGetPrefixes(c, charMap);
            for (TrieNode prefix : prefixes) {
                if (prefix.word.length() > maxLength) {
                    words = new ArrayList<>();
                    maxLength = prefix.word.length();
                }
                words.add(prefix.word);
            }
        }
        return words;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] dictionary = {"to", "banana", "toe", "dogs", "ababcd", "elephant"};
        String letters = "ogtdes";
        //String letters = "eot";
        System.out.println(getLongestValidWords(dictionary, letters));
    }
}
