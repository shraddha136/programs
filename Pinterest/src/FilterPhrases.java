import java.util.ArrayList;
import java.util.*;

class TrieNode {
    boolean isEnd;
    Map<String, TrieNode> children;

    TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // "free movie downloads",
    public void addPhrase(String phrase) {
        TrieNode current = root;
        for (String word : phrase.split(" ")) {
            if (!current.children.containsKey(word)) {
                current.children.put(word, new TrieNode());
            }
            //get me child which has the next word
            current = current.children.get(word);
        }
        current.isEnd = true;
    }

    public String checkUnsafe(String phrase) {
        if (phrase == null || phrase.length() == 0) {
            return "safe";
        }

        TrieNode current = root;
        String[] phraseArray = phrase.split(" ");
        for (int index = 0; index < phraseArray.length; index++) {
            String word = phraseArray[index];
            if (current == null || !current.children.containsKey(word)) {
                continue;
            }
            if (current.children.containsKey(word)) {
                if (foundSubPhrase(phraseArray, index)) {
                    return "unsafe";
                }
            }
        }
        return "safe";
    }

    private boolean foundSubPhrase(String[] phraseArray, int index) {
        TrieNode current = root;
        for (int wordIndex = index; wordIndex < phraseArray.length; wordIndex++) {
            String currentWord = phraseArray[wordIndex];
            if (current == null || !current.children.containsKey(currentWord)) {
                return false;
            }
            current = current.children.get(currentWord);
            if (current.isEnd) {
                return true;
            }
        }
        return false;
    }
}

class FilterPhrases {

    public static void main(String[] args) {

        Trie trie = new Trie();
        String[] badPhrases = {
                "free movie downloads",
                "free ray bans",
                "pornography",
                "world war i",
                "world war ii",
        };
        for (String phrase : badPhrases) {
            trie.addPhrase(phrase);
        }

        String[] phrases = {
                "how to get free movie downloads done",
                "is pornography on the site?",
                "i am new here",
                "show me new movie details",
                "i have free ray bans for you",
                "let's go out for dinner"
        };
        for (String phrase : phrases) {
            System.out.println(phrase + ":" + trie.checkUnsafe(phrase));
        }
    }
}
