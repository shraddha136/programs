import java.util.*;

public class Anagrams {
    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        List<List<String>> anagrams = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            char[] cw = word.toCharArray();
            Arrays.sort(cw);
            String curr = String.valueOf(cw);
            List<String> list;
            if (!map.containsKey(curr)) {
                list = new ArrayList<>();
            } else {
                list = map.get(curr);
            }
            list.add(word);
            map.put(curr, list);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < entry.getValue().size(); i++) {
                list.add(map.get(entry.getKey()).get(i));
            }
            anagrams.add(list);
        }
        return anagrams;
    }

    public static void main(String[] args) {
        String[] words = {"yo", "act", "flop", "tac", "cat", "oy", "olfp"};
        System.out.println(groupAnagrams(Arrays.asList(words)));
    }
}
