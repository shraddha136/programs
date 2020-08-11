import java.util.*;

public class MinWindowSubString {
    public String minWindow(String s, String t) {
        //map - to store the pattern
        //count variable to check len == pattern len
        //minLength - result
        // start and end

        Map<Character, Integer> charMap = getCharMap(t);
        int patternLen = t.length();
        int minLength = s.length();
        String min = "";
        int charCount = 0;
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            char current = s.charAt(end);
            if (charMap.containsKey(current)) {
                charMap.put(current, charMap.get(current) - 1);
                if(charMap.get(current)>=0)
                    charCount++;
            }
            while (charCount == patternLen) {
                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    min = s.substring(start, end + 1);
                }

                char c = s.charAt(start);
                if (charMap.containsKey(c)) {
                    if(charMap.get(c)==0)
                        charCount--;
                    charMap.put(c, charMap.get(c) + 1);
                }

                start++;
            }
            end++;
        }
        return min;
    }

    private Map<Character, Integer> getCharMap(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        return charMap;
    }

    public static void main(String[] args) {
        String s = "abc";

        String t = "ac";
        System.out.println(new MinWindowSubString().minWindow(s,t));
    }
}
