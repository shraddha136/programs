import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        int start = 0;
        int end = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (end < str.length()){
            char c = str.charAt(end);
            while (set.contains(c)){
                char s = str.charAt(start++);
                set.remove(s);
            }
            set.add(c);
            maxLen = Math.max(maxLen,end-start+1);
            end++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}

