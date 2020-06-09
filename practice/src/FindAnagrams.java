import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (char c : p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c)==0)
                    count++;
            }
                if (count == map.size())
                    result.add(j);

                if (i >= p.length() - 1) {

                    char x = s.charAt(j++);
                    if (map.containsKey(x)) {
                        if (map.get(x) == 0)
                            count--;
                        map.put(x, map.getOrDefault(x, 0) + 1);
                    }
                }
            }

            return result;
        }

        public static void main (String[]args){
            System.out.println(new FindAnagrams().findAnagrams("baa", "aa"));
        }
    }
