import java.util.Iterator;
import java.util.LinkedHashMap;

public class FirstUnique {
    public int firstUniqChar(String s) {
        int[] charSet = new int[26];
        for(char c:s.toCharArray()){
            charSet[c-'a']++;
        }

        for(int i = 0;i<s.length();i++){
            if(charSet[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUnique().firstUniqChar("leetcode"));
    }
}
