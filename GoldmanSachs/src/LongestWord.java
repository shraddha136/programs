import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWord {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()){
                    return s2.compareTo(s1);
                }else{
                    return s2.length()-s1.length();
                }
            }

        });
        for(String word:d){
            if(subsequence(s,word)){
                return word;
            }
        }
        return longest;
    }
    private boolean subsequence(String s, String t){
        int i = 0;
        int j = 0;
        int count = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                j++;
                count++;
            }
            i++;
        }
        return count == t.length();
    }
    public static void main(String[] args) {
//        String[] words = {"b", "c", "a","hello","aca"};
        String[] words = {"ale", "apple", "monkey", "plea"};
        System.out.println(new LongestWord().findLongestWord("abpcplea", Arrays.asList(words)));
    }
}

