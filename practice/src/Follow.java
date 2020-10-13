import java.util.*;

public class Follow {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> seen = new HashSet<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        int i = 0;
        while (i < pattern.length()) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (!seen.contains(words[i])) {

                    map.put(c, words[i]);
                    seen.add(words[i]);
                    i++;
                } else {
                    return false;
                }
            } else {
                if (words[i].equals(map.get(c))) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Follow().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Follow().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new Follow().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new Follow().wordPattern("abba", "dog dog dog dog"));
    }
}
