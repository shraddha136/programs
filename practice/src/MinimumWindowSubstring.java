import java.util.*;

class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        // TODO: Write your code here
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int count = 0;
        int minString = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        while (j < str.length()) {
            char c = str.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0)
                    count++;
            }
            while (count == pattern.length()) {
                if (min > j - i + 1) {
                    min = j - i + 1;
                    minString = i;
                }
                char x = str.charAt(i++);
                if (map.containsKey(x)) {
                    if (map.get(x) == 0)
                        count--;
                    map.put(x, map.getOrDefault(x, 0) + 1);
                }
            }

            j++;

        }


        return min == Integer.MAX_VALUE ? "" : str.substring(minString, minString + min);
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdabca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}
