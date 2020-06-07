import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumbersEqualDigitSum {
    //[51,71,17,42]
    //find pair with equal sum - 51,42 and 71,17
    // pair with max sum 93 - 51,42
    public int numEqualSum(int[] nums) {
        int maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int sum = getSum(n);
            if (map.containsKey(sum)){
                maxSum = Math.max(map.get(sum)+n,maxSum);
            }
            else {
                map.put(sum,n);
            }
        }

        return maxSum;
    }

    private int getSum(int n) {
        int sum = 0;
        do {
            sum += n % 10;
            n = n / 10;
        } while (n != 0);
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {51,71,17,42};
        System.out.println(new NumbersEqualDigitSum().numEqualSum(nums));
    }
}
