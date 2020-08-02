import java.util.*;

public class KDistinct1Repeating {
    public static void main(String[] args) {
        String s = "awaglak";
        System.out.println(getSubStrings(s, 4));
    }

    private static List<String> getSubStrings(String s, int k) {
        int start = 0;
        int end = 0;
        Set<Character> charset = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (!map.containsKey(c)) {
                map.put(c, 1);
                charset.add(c);
            } else {
                map.put(c, map.get(c) + 1);
            }
            if (end - start + 1 == k) {
                if (oneRepeat(s.substring(start, end + 1))) {
                    result.add(s.substring(start, end + 1));
                }
                char atStart = s.charAt(start++);
                map.put(atStart, map.get(atStart) - 1);
                if (map.get(atStart) == 0) {
                    map.remove(atStart);
                    charset.remove(atStart);
                }

            }
            end++;
        }
        return result;

    }

    private static boolean oneRepeat(String substring) {
        boolean repeat = false;
        int[] charset = new int[26];
        for (char c : substring.toCharArray()) {
            charset[c - 'a']++;
            if (charset[c - 'a'] == 2 && repeat) {
                return false;
            }
            if (charset[c - 'a'] == 2) {
                repeat = true;
            }
        }
        return repeat;
    }
}
