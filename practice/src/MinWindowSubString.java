import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MinWindowSubString {
    public String minWindow(String s, String t) {
        if (s == null || t == null)
            return "";
        if (s.length() == 0 || t.length() == 0)
            return "";
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        int size = t.length();
        int i = 0;
        int j = 0;
        int minLength = Integer.MAX_VALUE;
        String minString = "";

        for (char c : t.toCharArray()) {
            set.add(c);
        }
        while (j < s.length()) {
            if (set.contains(s.charAt(j)) && !map.containsKey(s.charAt(j)) && map.size() < t.length()) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            }




            if (map.size() == size) {
                if(minLength>j-i+1) {
                    minLength = Math.min(minLength, j - i + 1);
                    minString = s.substring(i, j + 1);
                }
                while (map.size() == size) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }

            }
            j++;
        }
        return minString;
    }

    public static void main(String[] args) {
        System.out.println(new MinWindowSubString().minWindow("ADOBECODEBANC","ABC"));
    }
}

