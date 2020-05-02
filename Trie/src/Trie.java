import java.util.ArrayList;
import java.util.Arrays;

public class Trie {
    private TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public int getIndex(char c) {
        return c - 'a';
    }

    //Function to insert a key,value pair in the Trie
    public void insert(String key) {
        TrieNode currNode = this.root;
        int index = 0;
        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currNode.children[index] == null) {
                currNode.children[index] = new TrieNode();
            }
            currNode = currNode.children[index];
        }
        currNode.setEndWord();
    }

    //Function to search given key in Trie
    public boolean search(String key) {
        TrieNode currNode = this.root;
        if (currNode == null)
            return false;
        int index = 0;
        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currNode.children[index] == null)
                return false;
            currNode = currNode.children[index];
        }

        return currNode.isEndWord;
    }

    //Function to delete given key from Trie
    public void delete(String key) {
        TrieNode currNode = this.root;
        if (currNode == null)
            return;
        deleteHelper(key, root, key.length(), 0);

//        int index  = 0;
//        for(int level = 0;level<key.length();level++){
//            index = getIndex(key.charAt(level));
//            if(currNode.children[index]==null)
//                return false;
//            currNode = currNode.children[index];
//        }
//        if(currNode.isEndWord)
    }

    private void deleteHelper(String key, TrieNode currNode, int length, int index) {
//        if(index == length)
//            return;
//            index = getIndex(key.charAt(level));
//            if (currNode.children[index] == null)
//                return;
//            currNode = currNode.children[index];
//            deleteHelper(key,currNode,length,index+1);
//        }
//        if (currNode.isEndWord)
    }
    public static int totalWords(TrieNode root){
        // Write - Your - Code
        if(root == null)
            return 0;
        int count = 0;
        if(root.isEndWord)
            count += 1;
        for(int i = 0;i<root.children.length;i++){
            if(root.children[i]!=null){
                count += totalWords(root.children[i]);
            }
        }
        return count;
    }

    public static void getWords(TrieNode root, ArrayList < String > result, int level, char[] str) {
        //Leaf denotes end of a word
        if (root.isEndWord) {
            //current word is stored till the 'level' in the character array
            String temp = "";
            for (int x = 0; x < level; x++) {
                temp += Character.toString(str[x]);
            }
            result.add(temp);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                //Non-null child, so add that index to the character array
                str[level] = (char)(i + 'a');
                getWords(root.children[i], result, level + 1, str);
            }
        }
    }
    public static ArrayList < String > findWords(TrieNode root) {
        ArrayList < String > result = new ArrayList < String > ();
        char[] chararr = new char[20];
        getWords(root, result, 0, chararr);
        return result;
    }

    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys to insert: " + Arrays.toString(keys) + "\n");

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++) {
            t.insert(keys[i]);
            System.out.println("\"" + keys[i] + "\"" + "Inserted.");
        }

        System.out.println(t.search("therekk"));
        System.out.println(totalWords(t.root));
//        System.out.println(t.delete("mango"));
        System.out.println(findWords(t.root));
    }
}
