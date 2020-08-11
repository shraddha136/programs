import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubString {
    Map<String, Integer> palinMap = new HashMap<>();

    public int findLCS(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        return getLCS(s, 0, s.length() - 1);
    }

    private int getLCS(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (palinMap.containsKey(s.substring(i, j + 1))) {
            return palinMap.get(s.substring(i, j + 1));
        }
        if (s.charAt(i) == s.charAt(j)) {
            int len = j - i - 1;
            if (len == getLCS(s, i + 1, j - 1)) {
                palinMap.put(s.substring(i, j + 1), 2 + len);
                return palinMap.get(s.substring(i, j + 1));
            }
        }
        palinMap.put(s.substring(i, j + 1), Math.max(getLCS(s, i + 1, j), getLCS(s, i, j - 1)));
        return palinMap.get(s.substring(i, j + 1));


    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new LongestPalindromicSubString().findLCS(s));
    }
}
