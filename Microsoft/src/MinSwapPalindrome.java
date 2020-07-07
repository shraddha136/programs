import java.util.HashSet;
import java.util.Set;

// see if the string is a shuffled palindrome
// start with 2 pointers
// if char at both pts is same, shrink the window
// if not, look for a matching char for the i'th char from jth towards i using k
// if match not found, swap i with ith char
// if match found, keep swapping from k to j and incr swapcount

public class MinSwapPalindrome {
    public static void main(String[] args) {
        System.out.println(new MinSwapPalindrome().getNoOfSwaps("mamad"));
        System.out.println(new MinSwapPalindrome().getNoOfSwaps("aabb"));
        System.out.println(new MinSwapPalindrome().getNoOfSwaps("asflkj"));
        System.out.println(new MinSwapPalindrome().getNoOfSwaps("ntiin"));
    }

    private int getNoOfSwaps(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        int swaps = 0;
        if (isPalindrome(string)) {
            int i = 0;
            int j = string.length() - 1;
            char[] s = string.toCharArray();
            while (i < j) {
                if (s[i] != s[j]) {
                    int k = j;
                    while (i < k && s[k] != s[i]) {
                        k--;
                    }
                    if (i == k) {
                        swap(s, i, i + 1);
                        swaps++;
                    } else {
                        while (k < j) {
                            swap(s, k, k + 1);
                            swaps++;
                            k++;
                        }
                    }
                }
                i++;
                j--;

            }
            return swaps;
        }
        return -1;
    }

    private void swap(char[] s, int i, int j) {
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }

    private boolean isPalindrome(String string) {
        boolean even = string.length() % 2 == 0;
        Set<Character> set = new HashSet<>();
        for (char c : string.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (even) {
            return set.size() <= 0;
        } else {
            return set.size() % 2 == 1;
        }
    }

}
