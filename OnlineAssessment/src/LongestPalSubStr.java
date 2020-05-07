import java.util.Arrays;
import java.util.List;

public class LongestPalSubStr {
    public int longestPalindrome(String s) {
        String longestPal = "";
        int i = 0;
        int j = s.length() - 1;
        return checkPal(s, i, j);
    }

    private int checkPal(String s, int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (s.charAt(i) == s.charAt(j)) {
            int rem = j - i - 1;
            if (rem == checkPal(s, i + 1, j - 1))
                return 2 + rem;
        }
            return Math.max(checkPal(s, i + 1, j), checkPal(s, i, j - 1));
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalSubStr().longestPalindrome("babad"));
        int[] array = new int[2];
        List<int[]> list = Arrays.asList();
        list.toArray();
    }
}
