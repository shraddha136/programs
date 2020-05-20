import java.util.Arrays;

public class Tries {
    class TrieNode{
        TrieNode[] children;
        boolean endWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.endWord = false;
        }

        public boolean isEndWord(){
            return this.endWord;
        }

        public void markEndWord(){
            this.endWord = true;
        }
        public void unMarkEndWord(){
            this.endWord = false;
        }
    }

    private TrieNode node;

    public Tries(){
        node = new TrieNode();
    }

    private int getIndex(char c){
        return c - 'a';
    }
    public void insert(String word){
        TrieNode curr = this.node;
        int index = 0;

        for(int level = 0;level<word.length();level++){
            index = getIndex(word.charAt(level));
            if(curr.children[index]==null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.markEndWord();
    }

    public boolean search(String word){
        if(this.node == null)
            return false;
        int index = 0;
        TrieNode curr = this.node;
        for(int level = 0;level<word.length();level++){
            index = getIndex(word.charAt(level));
            if(curr.children[index]==null)
                return false;
            curr = curr.children[index];
        }
        return curr.isEndWord();
    }

    public void delete(String word){
        TrieNode curr = this.node;
        if(curr == null)
            return;
        int index = 0;
        for(int level = 0;level<word.length();level++){
            index = getIndex(word.charAt(level));
            if(curr.children[index]==null)
                return;

        }
    }
}

class TrieDemo{
    public static void main(String[] args){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Tries t = new Tries();

        System.out.println("Keys to insert: "+ Arrays.toString(keys) + "\n");

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
        {
            t.insert(keys[i]);
            System.out.println("\""+ keys[i]+ "\"" + "Inserted.");
        }

        // Search for different keys
        if(t.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(t.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(t.search("abc") == true)
            System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);
    }

}
