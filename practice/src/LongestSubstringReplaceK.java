import java.util.HashMap;
import java.util.Map;

public class LongestSubstringReplaceK {
    //bccbababd k = 2
    // start, end
    // map with letter freq
    // max freq in a window

    //start = 0. end = 4 maxFreq = 2, maxLen = 4
    // b = 1 , c = 2, a = 1
    //end - maxFreq == k -> take maxLen
    //if(end - start +1-maxFreq > k)-> incr start ??
    public int maxLength(String s, int k){
        int start = 0;
        int end = 0;
        Map<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        int maxFreq = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq,map.get(c));

            if(end - start + 1 - maxFreq > k){
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start++;
            }
            maxLength = Math.max(maxLength,end-start+1);
            end++;
        }
     return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringReplaceK().maxLength("bccbababd",2));
    }
}
