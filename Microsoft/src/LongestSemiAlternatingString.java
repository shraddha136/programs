public class LongestSemiAlternatingString {
    public static int longestSemiAlt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 1;
        int start = 0;
        int end = 1;
        int maxLen = 1;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (c == s.charAt(end - 1)) {
                count++;

                if (count > 2) {
                    start = end - 1;
                }
            } else {
                count = 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);


            end++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSemiAlt("baaabbabbb"));
        System.out.println(longestSemiAlt("babba"));
        System.out.println(longestSemiAlt("abaaaa"));
        System.out.println(longestSemiAlt("a"));
    }
}
