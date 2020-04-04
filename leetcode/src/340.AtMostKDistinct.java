import java.util.LinkedHashMap;
import java.util.Map;

class AtMostKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        int maxLen = 1;
        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new LinkedHashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);

            if(map.containsKey(c))
                map.remove(c);
            map.put(c, right++);

            if (map.size() == k + 1) {
                Map.Entry<Character, Integer> leftIdx = map.entrySet().iterator().next();
                left = leftIdx.getValue() + 1;
                map.remove(leftIdx.getKey());
            }
            maxLen = Math.max(maxLen, right - left);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "LOVELEETCODE";
        System.out.println(new AtMostKDistinct().lengthOfLongestSubstringKDistinct(s, 4));
    }
}
