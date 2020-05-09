import java.util.HashMap;
import java.util.Map;

public class LongestSSDup {
    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        Map<Character,Integer> map = new HashMap<>();
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        String max = "";
        int i = 0;
        for(;i<str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                if(i-j>maxLen){
                    maxLen = i - j;
                    max = str.substring(j,i);
                }
                int x = map.get(c);
                for(int m = j;m<=x;m++)
                    map.remove(str.charAt(m));
                j = x+1;
            }
            map.put(c,i);
        }
        if(i - j > maxLen){
            max = str.substring(j,i);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("abcdabcef"));
    }
}
