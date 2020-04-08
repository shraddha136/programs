import java.util.ArrayList;
import java.util.List;

class KthPermutation {
    static void findKthPermutation(List<Character> v, int k, StringBuilder result) {
        //TODO: Write - Your - Code

        int n = v.size();
        for (int i = n; n > 0; n--) {
            int blockSize = factorial(i - 1);
            int digit = (k - 1) / blockSize;
            result.append(v.get(digit));
            v.remove(digit);
            k = k - blockSize * digit;
        }

    }

    private static int factorial(int i) {
        int n = 1;
        while (i > 0) {
            n *= i--;
        }
        return n;
    }
    static String getPermutation(int n, int k) {
        List<Character> v = new ArrayList<Character>();
        char c = '1';
        for (int i = 1; i <= n; ++i) {
            v.add(c);
            c++;
        }

        StringBuilder result = new StringBuilder();
        findKthPermutation(v, k, result);
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println("8th permutation of 1234 = " + getPermutation(4, 8));
    }
}  