import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            List<String> list;
            if (map.containsKey(Arrays.toString(sArray))) {
                list = map.get(Arrays.toString(sArray));
                list.add(s);
            } else {
                list = new ArrayList<>();
                list.add(s);
            }
            map.put(Arrays.toString(sArray), list);
        }
        List<List<String>> result = new ArrayList<>();

        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
}
