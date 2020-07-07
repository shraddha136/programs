import java.util.HashMap;
import java.util.Map;

public class NumberWithEqualDigitSum {
    //return the max sum of 2 numbers whose digits add up to an equal sum
    // map sum and digit. when same sum found, see if it is the maxsum, else update sum O(N log(d)) . Sum of digits takes log(d) time
    public int maxSum(int[] array) {
        //map with sum and list of numbers
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;
        for (int num : array) {
            //get sum of digits of each number
            int sumOfDigits = getSum(num);
            if (!map.containsKey(sumOfDigits)) {
                map.put(sumOfDigits, num);
            } else {
                int currSum = map.get(sumOfDigits) + num;
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
                map.put(sumOfDigits, currSum);
            }
        }
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }

    private int getSum(int num) {
        int sum = 0;
        do {
            sum += num % 10;
            num /= 10;
        } while (num > 0);
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {51, 71, 17, 42};
        System.out.println(new NumberWithEqualDigitSum().maxSum(a));
        int[] b = {42, 44, 60};
        System.out.println(new NumberWithEqualDigitSum().maxSum(b));
        int[] c = {51, 32, 43};
        System.out.println(new NumberWithEqualDigitSum().maxSum(c));
    }
}
