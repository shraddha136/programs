import java.util.HashMap;

class LongestSubstringnoRepeat {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();
        int maxLen = 0;
        int j = 0;
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j)))
                i = Math.max(map.get(s.charAt(j)), i);

            maxLen = Math.max(maxLen, j - i+1);
            map.put(s.charAt(j), j+1);

            j++;
        }
        return maxLen > 0 ? maxLen : map.size();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
