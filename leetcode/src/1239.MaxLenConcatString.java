import java.util.*;

class MaxLenConcatString {
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0)
            return 0;
        int[] res = new int[1];
        findMaxUnique(arr, 0, "", res);
        return res[0];
    }

    private void findMaxUnique(List<String> arr, int i, String s, int[] res) {
        if (i == arr.size() && uniqueCount(s) > res[0]) {
            res[0] = s.length();
            return;
        }
        if (i == arr.size())
            return;
        findMaxUnique(arr, i + 1, s, res);
        findMaxUnique(arr, i + 1, s + arr.get(i), res);

    }

    private int uniqueCount(String s) {
        int count = 0;
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            if (charCount[c - 'a'] > 0)
                return -1;
            else {
                charCount[c - 'a'] = 1;
                count++;
            }
        }
        return count;

    }


    public static void main(String[] args) {
        System.out.println(new MaxLenConcatString().maxLength(Arrays.asList("a", "abc", "d", "de", "def")));
        System.out.println(new MaxLenConcatString().maxLength(Arrays.asList("cha", "r", "act", "ers")));
        System.out.println(new MaxLenConcatString().maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }
}
